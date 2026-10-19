@echo off
setlocal EnableExtensions DisableDelayedExpansion
title WinProxy Auto-Installer ^| Win Community

:: Check if LocalAppData scripts folder is writable without elevation
set "TARGET_DIR=%LOCALAPPDATA%\Growtopia\scripts"
if not exist "%TARGET_DIR%" mkdir "%TARGET_DIR%" >nul 2>&1

:: Test write permissions
copy /y nul "%TARGET_DIR%\.perm_test" >nul 2>&1
if errorlevel 1 (
    :: Not writable, elevate to admin
    net session >nul 2>&1
    if errorlevel 1 (
        powershell -NoProfile -ExecutionPolicy Bypass -Command "Start-Process -FilePath '%~f0' -ArgumentList '%*' -Verb RunAs"
        exit /b
    )
) else (
    del "%TARGET_DIR%\.perm_test" >nul 2>&1
)

set "psFile=%TEMP%\WinProxyInstaller_%RANDOM%%RANDOM%.ps1"

powershell -NoProfile -ExecutionPolicy Bypass -Command ^
  "$lines = Get-Content -LiteralPath '%~f0'; $marker = ':__WINPROXY_POWERSHELL__'; $index = [Array]::IndexOf($lines, $marker); if ($index -lt 0) { throw 'Embedded PowerShell payload not found.' }; $payload = $lines[($index + 1)..($lines.Length - 1)] -join [Environment]::NewLine; Set-Content -LiteralPath '%psFile%' -Value $payload -Encoding UTF8"

if errorlevel 1 (
    echo [ERROR] Failed to extract installer payload.
    pause
    exit /b 1
)

powershell -NoProfile -ExecutionPolicy Bypass -File "%psFile%" %*
set "exitCode=%errorlevel%"

del "%psFile%" >nul 2>&1
exit /b %exitCode%

:__WINPROXY_POWERSHELL__
param(
    [string]$CommandArg = ""
)

$ErrorActionPreference = 'Stop'
[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12 -bor [Net.SecurityProtocolType]::Tls13

# ==================== CONFIGURATION ====================
$script:AppName     = "WINPROXY AUTO-INSTALLER"
$script:AppSubtitle = "WIN COMMUNITY // OFFICIAL CLOUD INSTALLER"
$script:Version     = "v2.5.0"

# Target download URLs from LansGameTry/WinProxyCPS
$script:LoaderUrl   = "https://raw.githubusercontent.com/LansGameTry/WinProxyCPS/main/-%20WinProxy%20Loader.lua"
$script:ConfigUrl   = "https://raw.githubusercontent.com/LansGameTry/WinProxyCPS/main/WinCommunity_Config.txt"

function Get-ScriptsPath {
    $localAppData = [Environment]::GetFolderPath('LocalApplicationData')
    $path = Join-Path (Join-Path $localAppData 'Growtopia') 'scripts'
    if (-not (Test-Path -LiteralPath $path)) {
        New-Item -ItemType Directory -Path $path -Force | Out-Null
    }
    return $path
}

function Download-FileWithFallback {
    param(
        [string]$Url,
        [string]$DestinationPath
    )
    
    $lastError = ""
    
    # Method 1: curl.exe (--ssl-no-revoke handles Windows Schannel offline revocation issues)
    $curlPath = Get-Command curl.exe -ErrorAction SilentlyContinue
    if ($null -ne $curlPath) {
        try {
            & curl.exe -s -S -L --ssl-no-revoke "$Url" -o "$DestinationPath" 2>$null
            if ((Test-Path -LiteralPath $DestinationPath) -and ((Get-Item -LiteralPath $DestinationPath).Length -gt 0)) {
                return $true
            }
        }
        catch {
            $lastError = $_.Exception.Message
        }
    }
    
    # Method 2: Invoke-WebRequest
    try {
        Invoke-WebRequest -Uri $Url -OutFile $DestinationPath -UseBasicParsing -TimeoutSec 15 -Headers @{ "User-Agent" = "WinProxy-Installer/2.5" }
        if ((Test-Path -LiteralPath $DestinationPath) -and ((Get-Item -LiteralPath $DestinationPath).Length -gt 0)) {
            return $true
        }
    }
    catch {
        $lastError = $_.Exception.Message
    }
    
    # Method 3: System.Net.WebClient
    try {
        $wc = New-Object System.Net.WebClient
        $wc.Headers.Add("User-Agent", "Mozilla/5.0")
        $wc.DownloadFile($Url, $DestinationPath)
        $wc.Dispose()
        if ((Test-Path -LiteralPath $DestinationPath) -and ((Get-Item -LiteralPath $DestinationPath).Length -gt 0)) {
            return $true
        }
    }
    catch {
        $lastError = $_.Exception.Message
    }
    
    throw ("Failed to download file from: {0}. Error: {1}" -f $Url, $lastError)
}

function Draw-Header {
    param([string]$StatusBadge = "ONLINE")
    
    try {
        [Console]::BackgroundColor = [ConsoleColor]::Black
        [Console]::ForegroundColor = [ConsoleColor]::Gray
    } catch {}
    
    Clear-Host
    Write-Host ""
    Write-Host "  ================================================================" -ForegroundColor DarkCyan
    Write-Host "   __          ___       _____                   " -ForegroundColor Cyan
    Write-Host "   \ \        / (_)     |  __ \                  " -ForegroundColor Cyan
    Write-Host "    \ \  /\  / / _ _ __ | |__) | __ _____  ___   " -ForegroundColor Cyan
    Write-Host "     \ \/  \/ / | | '_ \|  ___/ '__/ _ \ \/ / | | | " -ForegroundColor Cyan
    Write-Host "      \  /\  /  | | | | | |   | | | (_) >  <| |_| | " -ForegroundColor Cyan
    Write-Host "       \/  \/   |_|_| |_|_|   |_|  \___/_/\_\\__, | " -ForegroundColor Cyan
    Write-Host "                                              __/ | " -ForegroundColor Cyan
    Write-Host "                                             |___/  " -ForegroundColor Cyan
    Write-Host "          WIN COMMUNITY // OFFICIAL                 " -ForegroundColor Green
    Write-Host "  ================================================================" -ForegroundColor DarkCyan
    Write-Host ("   SYSTEM STATUS : [{0}]     VERSION : {1}" -f $StatusBadge, $script:Version) -ForegroundColor DarkGreen
    Write-Host "  ================================================================" -ForegroundColor DarkCyan
    Write-Host ""
}

function Start-DirectInstall {
    Draw-Header -StatusBadge "INSTALLING"
    
    $rootPath   = Get-ScriptsPath
    $fileLoader = Join-Path $rootPath '! WinProxy Loader.lua'
    $fileAlt    = Join-Path $rootPath '- WinProxy Loader.lua'
    $fileCfg    = Join-Path $rootPath 'WinCommunity_Config.txt'
    
    Write-Host "  [+] Starting 1-Click WinProxy Installation..." -ForegroundColor Cyan
    Write-Host ("      Target Path: {0}" -f $rootPath) -ForegroundColor DarkGray
    Write-Host ""
    
    # 1. Scripts directory verification
    if (-not (Test-Path -LiteralPath $rootPath)) {
        Write-Host "  [1/3] Creating Growtopia scripts folder..." -ForegroundColor Gray
        New-Item -ItemType Directory -Path $rootPath -Force | Out-Null
    } else {
        Write-Host "  [1/3] Growtopia scripts folder detected: [OK]" -ForegroundColor Green
    }
    
    # 2. Download Loader Script
    Write-Host "  [2/3] Downloading '! WinProxy Loader.lua'..." -ForegroundColor Yellow
    try {
        $null = Download-FileWithFallback -Url $script:LoaderUrl -DestinationPath $fileLoader
        # Mirror to "- WinProxy Loader.lua" for compatibility across all executors
        Copy-Item -LiteralPath $fileLoader -Destination $fileAlt -Force
        $size = (Get-Item -LiteralPath $fileLoader).Length
        Write-Host ("        Downloaded successfully! ({0} bytes)" -f $size) -ForegroundColor Green
    }
    catch {
        Write-Host ("        [FAILED] " + $_.Exception.Message) -ForegroundColor Red
        Write-Host "`n  Installation aborted due to an error." -ForegroundColor Red
        Write-Host "  Press any key to exit..." -ForegroundColor DarkGray
        try { [void][Console]::ReadKey($true) } catch {}
        exit 1
    }
    
    # 3. Download Default Config if not present
    if (-not (Test-Path -LiteralPath $fileCfg)) {
        Write-Host "  [3/3] Downloading default WinCommunity_Config.txt..." -ForegroundColor Yellow
        try {
            $null = Download-FileWithFallback -Url $script:ConfigUrl -DestinationPath $fileCfg
            Write-Host "        Default config installed successfully!" -ForegroundColor Green
        }
        catch {
            Write-Host "        (Notice: Default config skipped; script uses built-in defaults)" -ForegroundColor DarkGray
        }
    } else {
        Write-Host "  [3/3] WinCommunity_Config.txt already exists (retained): [OK]" -ForegroundColor Green
    }
    
    Write-Host ""
    Write-Host "  ================================================================" -ForegroundColor Green
    Write-Host "   [SUCCESS] WINPROXY INSTALLED / UPDATED SUCCESSFULLY!" -ForegroundColor Green
    Write-Host "  ================================================================" -ForegroundColor Green
    Write-Host "   Installed File in Growtopia:" -ForegroundColor Cyan
    Write-Host ("    * {0}" -f (Split-Path -Leaf $fileLoader)) -ForegroundColor White
    Write-Host ""
    Write-Host "   CLOUD AUTO-UPDATE:" -ForegroundColor Green
    Write-Host "    This loader automatically fetches the latest WinProxy updates" -ForegroundColor Gray
    Write-Host "    from the cloud whenever executed. No re-download needed!" -ForegroundColor Gray
    Write-Host ""
    Write-Host "   HOW TO RUN IN GROWTOPIA:" -ForegroundColor Yellow
    Write-Host "    1. Open Growtopia and your Proxy / Executor." -ForegroundColor Gray
    Write-Host "    2. Open your Script Executor menu." -ForegroundColor Gray
    Write-Host "    3. Select and execute: '! WinProxy Loader.lua'" -ForegroundColor Cyan
    Write-Host "  ================================================================" -ForegroundColor Green
    Write-Host ""
    
    try { [Console]::Beep(1000, 200) } catch {}
    
    # If not silent / redirected, wait for key
    if ($CommandArg -ne "/silent" -and -not [Console]::IsInputRedirected) {
        Write-Host "  Press any key to exit..." -ForegroundColor DarkGray
        try {
            [void][Console]::ReadKey($true)
        } catch {}
    }
}

Start-DirectInstall
