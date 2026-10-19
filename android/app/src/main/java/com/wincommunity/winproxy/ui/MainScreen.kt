package com.wincommunity.winproxy.ui

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wincommunity.winproxy.downloader.DownloadState
import com.wincommunity.winproxy.downloader.ScriptDownloader
import com.wincommunity.winproxy.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    downloader: ScriptDownloader,
    onCheckStoragePermission: () -> Boolean,
    onRequestStoragePermission: () -> Unit
) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("INSTALLER", "TUTORIAL", "COMMANDS")

    // Liquid Glass Deep Ocean Gradient
    val backgroundBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF030712),
            Color(0xFF070E1E),
            Color(0xFF0F172A)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Liquid Glass Top Header
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp, vertical = 20.dp)
            ) {
                Column {
                    Text(
                        text = "WINPROXY",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Black,
                        color = TextPrimary,
                        letterSpacing = 2.sp
                    )
                    Text(
                        text = "WIN COMMUNITY // OFFICIAL",
                        fontSize = 10.sp,
                        color = CyanPrimary,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                }

                // Frosted Glass Status Pill
                Box(
                    modifier = Modifier
                        .background(Color(0x2610B981), RoundedCornerShape(20.dp))
                        .border(1.dp, Color(0x6610B981), RoundedCornerShape(20.dp))
                        .padding(horizontal = 12.dp, vertical = 5.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .background(NeonGreen, CircleShape)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "ONLINE",
                            color = NeonGreen,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.5.sp
                        )
                    }
                }
            }

            // Floating Glass Tabs Capsule
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 4.dp)
                    .background(Color(0x1AFFFFFF), RoundedCornerShape(20.dp))
                    .border(1.dp, GlassBorder, RoundedCornerShape(20.dp))
                    .padding(4.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    tabs.forEachIndexed { index, title ->
                        val isSelected = selectedTab == index
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .weight(1f)
                                .height(38.dp)
                                .background(
                                    if (isSelected) Color(0x33FFFFFF) else Color.Transparent,
                                    RoundedCornerShape(16.dp)
                                )
                                .then(
                                    if (isSelected) Modifier.border(1.dp, GlassHighlight, RoundedCornerShape(16.dp))
                                    else Modifier
                                )
                                .clickable { selectedTab = index }
                        ) {
                            Text(
                                text = title,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                color = if (isSelected) TextPrimary else TextSecondary,
                                fontSize = 11.sp,
                                letterSpacing = 0.5.sp
                            )
                        }
                    }
                }
            }

            // Tab Content
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            ) {
                when (selectedTab) {
                    0 -> InstallerTab(
                        downloader = downloader,
                        onCheckStoragePermission = onCheckStoragePermission,
                        onRequestStoragePermission = onRequestStoragePermission
                    )
                    1 -> TutorialTab()
                    2 -> CommandsTab()
                }
            }
        }
    }
}

@Composable
fun InstallerTab(
    downloader: ScriptDownloader,
    onCheckStoragePermission: () -> Boolean,
    onRequestStoragePermission: () -> Unit
) {
    val downloadState by downloader.downloadState.collectAsState()
    val scope = rememberCoroutineScope()

    val safPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocumentTree()
    ) { uri: Uri? ->
        if (uri != null) {
            scope.launch {
                downloader.installToSafUri(uri)
            }
        }
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(14.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            // Main Liquid Glass Card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(GlassSurface, RoundedCornerShape(24.dp))
                    .border(1.dp, GlassBorder, RoundedCornerShape(24.dp))
                    .padding(22.dp)
            ) {
                Column {
                    Text(
                        text = "AUTO-INSTALL LOADER",
                        color = TextPrimary,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Automatically downloads '! WinProxy Loader.lua' to your Growtopia directory. It always fetches the latest script updates directly from the cloud.",
                        color = TextSecondary,
                        fontSize = 12.sp,
                        lineHeight = 18.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // Download State Display
                    when (val state = downloadState) {
                        is DownloadState.Downloading -> {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Downloading: ${state.currentFile}",
                                        color = CyanPrimary,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Text(
                                        text = "${state.progress}%",
                                        color = CyanPrimary,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                LinearProgressIndicator(
                                    modifier = Modifier.fillMaxWidth(),
                                    color = CyanPrimary,
                                    trackColor = Color(0x33FFFFFF)
                                )
                            }
                            Spacer(modifier = Modifier.height(14.dp))
                        }

                        is DownloadState.Success -> {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color(0x2E10B981), RoundedCornerShape(16.dp))
                                    .border(1.dp, Color(0x8010B981), RoundedCornerShape(16.dp))
                                    .padding(14.dp)
                            ) {
                                Column {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = NeonGreen)
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = "INSTALLATION SUCCESSFUL!",
                                            color = NeonGreen,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 14.sp
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "Path: ${state.installedPath}",
                                        color = TextPrimary,
                                        fontSize = 11.sp
                                    )
                                    Text(
                                        text = "Open Bothax / Executor in Growtopia and execute '! WinProxy Loader.lua'.",
                                        color = TextSecondary,
                                        fontSize = 11.sp
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(14.dp))
                        }

                        is DownloadState.Error -> {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color(0x33FF5252), RoundedCornerShape(16.dp))
                                    .border(1.dp, Color(0x80FF5252), RoundedCornerShape(16.dp))
                                    .padding(14.dp)
                            ) {
                                Column {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(Icons.Default.Error, contentDescription = null, tint = RedError)
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = "DOWNLOAD FAILED",
                                            color = RedError,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 14.sp
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(text = state.message, color = TextPrimary, fontSize = 11.sp)
                                }
                            }
                            Spacer(modifier = Modifier.height(14.dp))
                        }

                        is DownloadState.Idle -> {}
                    }

                    // Liquid Cyan Primary Button
                    val buttonBrush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF00E5FF), Color(0xFF00B0FF), Color(0xFF3B82F6))
                    )
                    Button(
                        onClick = {
                            if (!onCheckStoragePermission()) {
                                onRequestStoragePermission()
                                return@Button
                            }
                            val candidates = downloader.getCandidateDirectories()
                            val target = candidates.firstOrNull { it.exists() && it.canWrite() } ?: candidates.first()
                            scope.launch {
                                downloader.installToDirectory(target)
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                            .background(buttonBrush, RoundedCornerShape(16.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        shape = RoundedCornerShape(16.dp),
                        enabled = downloadState !is DownloadState.Downloading
                    ) {
                        Icon(Icons.Default.Download, contentDescription = null, tint = Color.Black)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (downloadState is DownloadState.Success) "RE-INSTALL WINPROXY" else "INSTALL / UPDATE WINPROXY",
                            color = Color.Black,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 13.sp,
                            letterSpacing = 0.5.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Frosted Glass Secondary Button
                    OutlinedButton(
                        onClick = { safPicker.launch(null) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .background(Color(0x0DFFFFFF), RoundedCornerShape(16.dp)),
                        shape = RoundedCornerShape(16.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, GlassBorder)
                    ) {
                        Icon(Icons.Default.FolderOpen, contentDescription = null, tint = CyanPrimary)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Choose Folder Manually (SAF)",
                            color = TextPrimary,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }

        item {
            // Target File Frosted Card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(GlassSurface, RoundedCornerShape(20.dp))
                    .border(1.dp, GlassBorder, RoundedCornerShape(20.dp))
                    .padding(18.dp)
            ) {
                Column {
                    Text(
                        text = "INSTALLED FILE:",
                        color = CyanPrimary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "• ! WinProxy Loader.lua (~142 bytes)", color = TextPrimary, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                    Text(text = "(Automatically loads the latest WinProxy script from the cloud)", color = NeonGreen, fontSize = 11.sp)
                }
            }
        }
    }
}

@Composable
fun TutorialTab() {
    val steps = listOf(
        "Tap the 'INSTALL / UPDATE WINPROXY' button in the Installer tab to download the loader.",
        "Launch your Growtopia executor (Bothax, Powerkuy, or Growlauncher).",
        "Go to Executor > Settings > API List, and ensure all permissions are checked: io, package, os, http, etc.",
        "Open your Executor's Script List tab.",
        "Select and run (Execute) '! WinProxy Loader.lua'.",
        "Enjoy WinProxy! Use in-game chat commands such as /menu or /cvdl."
    )

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Text(
                text = "ANDROID SETUP GUIDE",
                color = CyanPrimary,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Follow these simple steps to ensure the script runs smoothly.",
                color = TextSecondary,
                fontSize = 11.sp
            )
            Spacer(modifier = Modifier.height(6.dp))
        }

        items(steps.mapIndexed { index, text -> Pair(index + 1, text) }) { (num, desc) ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(GlassSurface, RoundedCornerShape(18.dp))
                    .border(1.dp, GlassBorder, RoundedCornerShape(18.dp))
                    .padding(14.dp)
            ) {
                Row(verticalAlignment = Alignment.Top) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(
                                Brush.horizontalGradient(listOf(CyanPrimary, CyanVariant)),
                                CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = num.toString(),
                            color = Color.Black,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 11.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = desc,
                        color = TextPrimary,
                        fontSize = 12.sp,
                        lineHeight = 18.sp
                    )
                }
            }
        }
    }
}

@Composable
fun CommandsTab() {
    val commandCategories = listOf(
        "CORE & SYSTEM" to listOf(
            "/proxy, /imgui" to "Toggle ImGui menu panel overlay",
            "/menu, /help" to "Open main dialog interface in-game",
            "/cmd" to "Open full Command Center dialog",
            "/settingmenu" to "Open settings & preferences menu",
            "/aliasmenu" to "Open custom command alias manager",
            "/g, /ghost" to "Quick shortcut for /ghost",
            "/res" to "Quick shortcut for respawn",
            "/re" to "Quick shortcut for rejoining world",
            "/relog" to "Quick shortcut to reconnect to server"
        ),
        "TELEPHONE & AUTO-BUY" to listOf(
            "/cvdl" to "Auto convert DL to BGL",
            "/buybgl" to "Auto buy Blue Gem Lock via telephone",
            "/buydl" to "Auto buy Diamond Lock via telephone",
            "/buychamp" to "Auto buy Champagne (World Lock)",
            "/buychampbg" to "Auto buy Champagne (Black Gems)",
            "/buychampbulk" to "Auto buy bulk Champagne",
            "/telemenu" to "Open Telephone shortcut menu"
        ),
        "ECONOMY & FAST DROP" to listOf(
            "/dw <qty>" to "Fast auto-drop World Lock",
            "/dd <qty>" to "Fast auto-drop Diamond Lock",
            "/db <qty>" to "Fast auto-drop Blue Gem Lock",
            "/dbl <qty>" to "Fast auto-drop Black Gem Lock",
            "/daw" to "Drop all locks in inventory instantly",
            "/depo <qty>" to "Deposit BGL directly to bank",
            "/with <qty>" to "Withdraw BGL directly from bank",
            "/blue" to "Convert Black GL to Blue GL",
            "/black" to "Convert Blue GL to Black GL"
        ),
        "AUTO PULL & WRENCH" to listOf(
            "/autopull" to "Toggle Auto Pull Master",
            "/posautopull" to "Set Auto Pull target to current tile",
            "/clearposautopull" to "Reset target tile to White Door",
            "/autopullmenu" to "Open Auto Pull configuration menu",
            "/apblacklist" to "Manage UID blacklist (add/remove/list)",
            "/wrp, /wrps" to "Auto Pull (Left / Right click wrench)",
            "/wrk, /wrks" to "Auto Kick (Left / Right click wrench)",
            "/wrb, /wrbs" to "Auto Ban (Left / Right click wrench)",
            "/wrt, /wrts" to "Auto Trade (Left / Right click wrench)",
            "/showbal" to "Toggle fast balance display on inspect"
        ),
        "CASINO & CALCULATOR" to listOf(
            "/casinomenu" to "Open Casino master control menu",
            "/allmode" to "Toggle All mode (Reme, Leme, Qeme)",
            "/reme" to "Toggle Reme calculator mode",
            "/qeme" to "Toggle Qeme calculator mode",
            "/leme, /lemes" to "Toggle Leme / Leme S calculator mode",
            "/ceme" to "Toggle Ceme calculator mode",
            "/lewa <num>" to "Set Lewa multiplier and enable mode",
            "/calc <math>" to "Smart in-game math calculator (/calc 5+5)",
            "/calcmenu" to "Open Calculator menu dialog"
        ),
        "SMART DONATION & TRADE" to listOf(
            "/dmode" to "Toggle Smart Donation mode",
            "/donatemenu" to "Open Donate configuration menu",
            "/pw, /pd, /pb" to "Remote donate WL / DL / BGL to box",
            "/pbl, /pall" to "Remote donate Black GL / All locks",
            "/takeall" to "Retrieve all items from donation box",
            "/tmode" to "Toggle Trade Wrench mode",
            "/tw, /td, /tb" to "Fast add WL / DL / BGL to trade window",
            "/tbl, /tall" to "Fast add Black GL / All locks to trade",
            "/tclear" to "Clear all locks from trade window"
        ),
        "GENERAL PROXY FEATURES" to listOf(
            "/antilag" to "Toggle anti-lag (removes particles/shadows)",
            "/modfly" to "Toggle flying mode (noclip)",
            "/antipickup" to "Toggle anti-pickup item protection",
            "/antiportal" to "Toggle anti-portal warp bypass",
            "/nightvision" to "Toggle full map night vision",
            "/fastdrop, /fasttrash" to "Bypass confirmation dialogs",
            "/autocv" to "Auto-convert all locks upon collection",
            "/modal" to "Calculate and show own total net worth",
            "/tp" to "Toggle Teleport Punch (Display/Vend)",
            "/blocksdb" to "Toggle blocking of SDB popup dialogs",
            "/vendfilter" to "Format display for large World Lock prices",
            "/donfilter" to "Render actual item icons in Dono Box",
            "/sboxfilter" to "Storage Box Xtreme Take-All mode"
        ),
        "AUTO-SPAM & BROADCAST" to listOf(
            "/spam" to "Toggle auto-spam messenger on/off",
            "/spammenu" to "Open Auto-Spam UI configuration",
            "/addspam <txt>" to "Add a new message to spam rotation",
            "/removespam" to "Remove the last message from spam",
            "/spamtext <idx>" to "Edit specific spam message line",
            "/sbmenu" to "Open Super Broadcast control dialog",
            "/sbstart, /sbstop" to "Start / Stop automated Super Broadcast",
            "/sdbstart, /sdbstop" to "Start / Stop Super Duper Broadcast"
        ),
        "CUSTOMIZATION & LOGS" to listOf(
            "/emojimenu" to "Open chat emoji and color styling menu",
            "/emoji" to "Toggle random chat emojis prefix",
            "/watermark" to "Toggle [@Win] chat watermark prefix",
            "/logsmenu" to "Open master activity logs dialog",
            "/logs" to "Toggle activity logging on/off",
            "/clogs, /dlogs" to "Open Collect / Drop detailed logs",
            "/invlogs, /slogs" to "Open Inventory / Casino & Spin logs"
        ),
        "BTK & BJ HOST GAMES" to listOf(
            "/btkmenu, /bjmenu" to "Open host game dialog panel",
            "/btkcmd, /bjcmd" to "Open BTK / BJ host commands cheat-sheet",
            "/btk, /bj" to "Switch host game mode (BTK or BJ)",
            "/btkremote, /bjremote" to "Collect remote from Magplant",
            "/btkbet, /bjbet" to "Take player bets & calculate host tax",
            "/btkgems, /bjgems" to "Check gems count & announce winner",
            "/btkdrop, /bjdrop" to "Drop prize pool, host tax & reset round",
            "/btkcenter, /bjcenter" to "Punch tile to set host center position",
            "/btkposbet1, /bjposbet1" to "Punch tile to set Player 1 bet position",
            "/btkposbet2, /bjposbet2" to "Punch tile to set Player 2 bet position",
            "/btkposbreak1, /bjposbreak1" to "Punch tile to set Player 1 break position",
            "/btkposbreak2, /bjposbreak2" to "Punch tile to set Player 2 break position",
            "/btktax, /bjtax" to "Punch tile to set host tax drop position",
            "/btkmag, /bjmag" to "Punch tile to set host Magplant position"
        )
    )

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Text(
                text = "WINPROXY COMMAND CENTER",
                color = CyanPrimary,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Official in-game chat commands from ! WinProxy.lua:",
                color = TextSecondary,
                fontSize = 11.sp
            )
            Spacer(modifier = Modifier.height(6.dp))
        }

        commandCategories.forEach { (categoryName, commands) ->
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = categoryName,
                    color = Color(0xB3FFFFFF),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }

            items(commands) { (cmd, desc) ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(GlassSurface, RoundedCornerShape(14.dp))
                        .border(1.dp, GlassBorder, RoundedCornerShape(14.dp))
                        .padding(horizontal = 14.dp, vertical = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = cmd,
                            color = CyanPrimary,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 12.sp,
                            modifier = Modifier.weight(0.45f, fill = false)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = desc,
                            color = TextSecondary,
                            fontSize = 11.sp,
                            modifier = Modifier.weight(0.55f, fill = false)
                        )
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
