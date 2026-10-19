# ðŸŽ® WINPROXY â€” Proxy CreativePS

**WinProxy** is an all-in-one proxy script for **Growtopia Private Server (CreativePS)** that runs on the **BotHax** executor. It comes with a **UID authentication system** (whitelist) and **automatic Discord notifications** every time the script is executed.

> âš ï¸ **Note:** This repository only contains the encrypted loader file. The source code is **not public**.

---

## ðŸ“¥ Quick Installation

### ðŸ’» Windows (1-Click Auto Installer)
1. Download **[WinProxy_Installer.bat](WinProxy_Installer.bat)**
2. Double-click to run â€” it automatically downloads `! WinProxy Loader.lua` to your Growtopia scripts folder.

### ðŸ“± Android (Liquid Glass Installer APK)
1. ðŸ“¥ **[Download WinProxy-Installer.apk (Latest)](https://github.com/LansGameTry/WinProxyCPS/raw/main/WinProxy-Installer.apk)**
2. Install & open the app on your Android device.
3. Tap **INSTALL / UPDATE WINPROXY**.

### âš¡ 1-Line In-Game Executor (Direct Run)
Paste this directly into your Growtopia executor textbox:
```lua
LoadEncrypt(MakeRequest("https://raw.githubusercontent.com/LansGameTry/WinProxyCPS/main/-%20WinProxy.lua_enc", "GET").content, 085121053060)
```

---

## ðŸš€ How to Use

1. Open your **Growtopia executor** (BotHax, Powerkuy, or Growlauncher)
2. Execute **`! WinProxy Loader.lua`** (one-time setup, auto-updates from cloud)
3. Type **`/imgui`** to open the ImGui menu, or **`/menu`** for the in-game dialog menu
4. All settings are saved automatically in `WinCommunity_Config.txt`

---

## âœ¨ Features

| Category | Features |
|----------|----------|
| ðŸ›¡ï¸ **General** | Anti-Pickup, Block SDB, Auto Pull + Blacklist, Teleport Punch, Show Balance, Fast Drop/Trash, Vend Filter, Donation Filter |
| ðŸ”§ **Wrench** | Auto Pull / Kick / Ban / Trade on wrenched player |
| ðŸ’° **Donate** | Smart Donation Box (remote donate WL/DL/BGL/BlackGL, take all) |
| ðŸ¤ **Trade** | Fast add WL/DL/BGL/BlackGL to trade |
| ðŸ“ž **Telephone** | Auto Convert DLâ†’BGL, Auto Buy BGL/DL/Champagne |
| ðŸŽ° **Casino** | Reme, Qeme, Leme, Leme S, Ceme, Lewa (with multiplier) |
| ðŸ§® **Calculator** | Instant math calculator via chat |
| ðŸŽ¨ **Emoji & Color** | Random emojis, chat watermark, chat colors, rainbow/blink skin |
| ðŸ“¦ **Item Database** | Search item info |
| ðŸŽ£ **Auto Fish** | Auto cast, auto bite, statistics |
| ðŸ¥ **Auto Surg** | Auto surgery + auto modage bypass |
| ðŸ¦¹ **Auto Crime** | Auto fight crime + auto buy cards |
| ðŸ“¢ **Auto Spam** | Multi-line spam with interval |
| ðŸ“¡ **Super Broadcast** | SB & SDB automation + Discord webhook |
| ðŸ“œ **All Logs** | Activity, casino, inventory, collect/drop logs |
| ðŸ›’ **Auto Buy Pack** | Auto scan & buy packs, batch mode, drop items |
| âš™ï¸ **Setting** | Save/load configuration |

> â³ **Coming Soon:** Auto Farm (PTHT/Splice/PNB/Rotasi/Tax), Auto Cook, Auto Geiger, BTK/BJ, Magplant, Vending, AFK, World

---

## âŒ¨ï¸ Complete Command List

### ðŸ–¥ï¸ System & Tools
| Command | Description |
|---------|-------------|
| `/menu` or `/help` | Open main menu |
| `/cmd` | Open command list |
| `/settingmenu` | Open settings menu |
| `/imgui` | Open/close ImGui panel |
| `/g` | Shortcut for /ghost |
| `/res` | Respawn |
| `/re` | Rejoin world |
| `/relog` | Reconnect server |
| `/proxy` | Toggle ImGui (alternative) |

### ðŸ›¡ï¸ General
| Command | Description |
|---------|-------------|
| `/antipickup` | Toggle anti-pickup |
| `/blocksdb` | Toggle block SDB dialog |
| `/autopull` | Toggle auto pull |
| `/tp` | Toggle teleport punch |
| `/showbal` | Toggle show balance |
| `/fastdrop` | Toggle fast drop |
| `/fasttrash` | Toggle fast trash |
| `/vendfilter` | Format large WL prices to BGL/DL |
| `/donfilter` | Show item icons in donation box |
| `/modal` | Calculate your own total balance |
| `/apblacklist add <UID>` | Add auto pull blacklist |
| `/apblacklist remove <UID>` | Remove blacklist |
| `/apblacklist list` | View blacklist list |

### ðŸ”§ Wrench
| Command | Description |
|---------|-------------|
| `/wrenchmenu` | Open wrench menu |
| `/wrp` | Toggle auto pull on wrenched player |
| `/wrk` | Toggle auto kick on wrenched player |
| `/wrb` | Toggle auto ban on wrenched player |
| `/wrt` | Toggle auto trade on wrenched player |

### ðŸ’° Donate
| Command | Description |
|---------|-------------|
| `/donatemenu` | Open donate menu |
| `/dmode` | Toggle smart donation mode |
| `/pw <qty>` | Donate World Lock |
| `/pd <qty>` | Donate Diamond Lock |
| `/pb <qty>` | Donate Blue Gem Lock |
| `/pbl <qty>` | Donate Black Gem Lock |
| `/takeall` | Retrieve all items from donation box |

### ðŸ¤ Trade
| Command | Description |
|---------|-------------|
| `/trademenu` | Open trade menu |
| `/tw <qty>` | Fast add World Lock to trade |
| `/td <qty>` | Fast add Diamond Lock to trade |
| `/tb <qty>` | Fast add Blue Gem Lock to trade |
| `/tbl <qty>` | Fast add Black Gem Lock to trade |

### ðŸ“ž Telephone
| Command | Description |
|---------|-------------|
| `/telemenu` | Open telephone menu |
| `/cvdl` | Auto convert DL to BGL |
| `/buybgl` | Auto buy Blue Gem Lock |
| `/buydl` | Auto buy Diamond Lock |
| `/buychamp` | Auto buy Champagne |

### ðŸŽ° Casino
| Command | Description |
|---------|-------------|
| `/casinomenu` | Open casino menu |
| `/reme` | Toggle Reme mode |
| `/qeme` | Toggle Qeme mode |
| `/leme` | Toggle Leme mode |
| `/lemes` | Toggle Leme S mode |
| `/ceme` | Toggle Ceme mode |
| `/lewa <num>` | Set Lewa multiplier and enable |

### ðŸ§® Calculator
| Command | Description |
|---------|-------------|
| `/calcmenu` | Open calculator menu |
| `/calc <form>` | Calculate math instantly (e.g. `/calc 5*5+2`) |

### ðŸ“¢ Auto Spam
| Command | Description |
|---------|-------------|
| `/spammenu` | Open spam menu |
| `/spam` | Toggle auto-spam |
| `/addspam <txt>` | Add a spam message |
| `/removespam` | Remove last spam message |
| `/spamtext <#> <txt>` | Edit specific spam line |

### ðŸ“¡ Super Broadcast
| Command | Description |
|---------|-------------|
| `/sbmenu` | Open SB & SDB menu |
| `/sbstart` | Start Super Broadcast |
| `/sbstop` | Stop Super Broadcast |
| `/sdbstart` | Start Super Duper Broadcast |
| `/sdbstop` | Stop Super Duper Broadcast |

### ðŸŽ¨ Emoji & Color
| Command | Description |
|---------|-------------|
| `/emojimenu` | Open emoji menu |
| `/emoji` | Toggle random chat emojis |
| `/watermark` | Toggle custom chat watermark |

### ðŸ“œ Logs
| Command | Description |
|---------|-------------|
| `/logsmenu` | Open logs menu |
| `/logs` | Toggle activity logging |
| `/clogs` | Open Collect Logs |
| `/dlogs` | Open Drop Logs |
| `/invlogs` | Open Inventory Logs |
| `/slogs` | Open Casino/Spin Logs |

### ðŸ’Ž Economy & Drop
| Command | Description |
|---------|-------------|
| `/dw <qty>` | Auto drop World Lock |
| `/dd <qty>` | Auto drop Diamond Lock |
| `/db <qty>` | Auto drop Blue Gem Lock |
| `/dbl <qty>` | Auto drop Black Gem Lock |
| `/daw` | Drop all locks in backpack |
| `/depo <qty>` | Deposit BGL to bank |
| `/with <qty>` | Withdraw BGL from bank |
| `/blue` | Convert Black GL to Blue GL |
| `/black` | Convert Blue GL to Black GL |

---

## ðŸ”’ Security

- **UID Authentication** â€” only whitelisted users can run the script
- **Discord Notifications** â€” every access (granted/denied) is sent to a webhook with GrowID, UserID, World, IP, and timestamp
- **Auto-Update** â€” the script always fetches the latest version, no need to re-download

---

## ðŸ“Œ Notes

- Some features marked *(Soon)* are still in development
- For custom commands, you can map your own shortcuts via the ImGui menu (e.g. `/di` â†’ `/dbl`)

