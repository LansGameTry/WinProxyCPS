# 🎮 WINPROXY — CreativePS Proxy Script

[![Platform: Windows & Android](https://img.shields.io/badge/Platform-Windows%20%7C%20Android-00E5FF?style=for-the-badge&logo=android)](https://github.com/LansGameTry/WinProxyCPS)
[![Status: Active](https://img.shields.io/badge/Status-Active%20%26%20Updated-10B981?style=for-the-badge)](https://github.com/LansGameTry/WinProxyCPS)
[![Executor: BotHax Only](https://img.shields.io/badge/Executor-BotHax%20Only-8B5CF6?style=for-the-badge)](https://github.com/LansGameTry/WinProxyCPS)

**WinProxy** is an all-in-one private server proxy script developed for **Growtopia Private Server (CreativePS)**. It is built **exclusively for the BotHax executor** (Windows & Android), equipped with a UID hardware whitelist authentication system and automatic Discord webhook activity notifications.

> ⚠️ **Notice:** This repository contains the official installation packages and encrypted cloud loader. The source code is private.

---

## 📥 Quick Installation

### 💻 Windows (1-Click Auto-Installer)
1. Download **[`WinProxy_Installer.bat`](https://github.com/LansGameTry/WinProxyCPS/raw/main/WinProxy_Installer.bat)**
2. Double-click to run — it automatically installs `! WinProxy Loader.lua` to `%LOCALAPPDATA%\Growtopia\scripts\`.

### 📱 Android (Official Installer APK)
1. Download **[`WinProxy-Installer.apk`](https://github.com/LansGameTry/WinProxyCPS/raw/main/WinProxy-Installer.apk)** (~14.6 MB)
2. Install & open the app on your Android device.
3. Tap **INSTALL / UPDATE WINPROXY** to automatically place the loader into your Growtopia directory.

### ⚡ 1-Line In-Game Executor (Direct Run)
Paste this directly into your **BotHax** executor textbox:
```lua
LoadEncrypt(MakeRequest("https://raw.githubusercontent.com/LansGameTry/WinProxyCPS/main/-%20WinProxy.lua_enc", "GET").content, 085121053060)
```

---

## 🚀 How to Use

1. Launch the **BotHax** executor in Growtopia.
2. Execute **`! WinProxy Loader.lua`** (one-time setup; automatically fetches the latest script updates from the cloud).
3. Type **`/imgui`** or **`/proxy`** in chat to toggle the visual ImGui overlay panel, or type **`/menu`** for the in-game dialog.
4. All your settings are automatically saved and preserved in `WinCommunity_Config.txt`.

---

## ✨ Features Status & Roadmap

### ✅ Ready & Implemented Features

| Category | Features Included |
| :--- | :--- |
| 🛡️ **General Proxy** | Anti-Lag (particles/shadows toggle), Hide Spammer Slave, Anti-Pickup items, Modfly (noclip), Anti-Portal warp bypass, Night Vision, Block SDB popups, Auto-convert all locks on collect, Teleport Punch (Display/Vend), Balance Net Worth Modal, Fast Drop (confirmation bypass), Fast Trash (confirmation bypass), Vend Large Price Formatter, Donation Box Icon Filter, Storage Box Xtreme Take-All mode. |
| 🧲 **Auto Pull & Target** | Master Auto Pull, Custom Tile Target Position, White Door Target Reset, Pull Configuration Dialog, UID Blacklist Manager (add, remove, list). |
| 🔧 **Wrench Controls** | Auto Pull on Wrench (Left/Right click), Auto Kick on Wrench (Left/Right click), Auto World Ban on Wrench (Left/Right click), Auto Trade on Wrench (Left/Right click), Fast Balance Inspect. |
| 🎁 **Smart Donation** | Smart Donation Box Mode, Remote Donate World Lock, Diamond Lock, Blue Gem Lock, Black Gem Lock, Remote Donate All Backpack Locks, Fast Retrieve All Items from Box. |
| 🤝 **Advanced Trading** | Trade Wrench Mode, Fast Add World Lock, Diamond Lock, Blue Gem Lock, Black Gem Lock, Fast Add All Locks to Trade, 1-Click Clear All Trade Locks. |
| 📞 **Telephone & Exchange** | Auto Convert DL to BGL, Auto Buy Blue Gem Lock, Auto Buy Diamond Lock, Auto Buy Champagne (WL), Auto Buy Champagne (BGL), Auto Buy Bulk Champagne, Telephone Menu. |
| 🎰 **Casino Suite** | Casino Master Dialog, All-In-One Casino Mode, Reme Calculator, Qeme Calculator, Leme Calculator, Leme S Calculator, Ceme Calculator, Lewa Multiplier System. |
| 👑 **BTK & BJ Host Games** | Host Panel Dialog, Host Commands Reference, Mode Switch (BTK / BJ), Magplant Remote Collector, Take Bets & Tax Calculator, Gems Counter & Winner Announcer, Prize Pool Drop & Tax Reset, Host Center Tile, Player Bet & Break Tiles, Tax Tile, Magplant Tile. |
| 🧮 **Smart Calculator** | Instant Math Expression Evaluator via Chat (`/calc <formula>`), Calculator Dialog. |
| 📢 **Auto-Spam & Broadcast** | Auto-Spam Messenger, Multi-Line Spam Rotation, Add/Remove/Edit Spam Lines, Super Broadcast (SB) Controller, Super Duper Broadcast (SDB) Controller. |
| 🎨 **Text, Skin & Style** | Random Chat Emojis Prefix, Custom Chat Watermark (`[@Win]`), Chat Encryption (XOR cipher), Rainbow/Blink Skin Effect, Theme & UI Customizer. |
| 📜 **Activity & Logs** | Master Logs Dialog, Activity Logging Toggle, Collect Logs, Drop Logs, Inventory Logs, Casino & Spin Logs. |
| 🤖 **Automated Bots** | **Auto Fish** (Auto Cast, Auto Bite, Auto Hook, Fishing Statistics)<br>**Auto Surgery** (Automated surgery + modage bypass)<br>**Auto Crime** (Automated crime cards + auto buy)<br>**Auto Buy Pack** (Scan & batch buy store packs, auto-drop)<br>**Magplant Automation** (Remote collector & task handlers)<br>**Vending Machine Automation** (Auto vend stocker & manager). |
| ⚙️ **System & Tools** | Custom Command Alias Manager, ImGui Window Overlay, Respawn Shortcut, Rejoin World Shortcut, Reconnect Server Shortcut. |

---

### ⏳ Coming Soon Features (In Development)

The following modules are currently in development and will be released in upcoming updates:

* 🚜 **Auto Farm**:
  * **Auto PTHT** — Automated Plant, Tree, and Harvest bot.
  * **Auto PNB** — Automated Place and Break block bot.
  * **Auto Rotasi** — Automated farm rotation system.
  * **Auto Tax** — Automated farm tax collector.
* 🍳 **Auto Cook** — Automated cooking assistant with recipe automation.
* ☢️ **Auto Geiger** — Automated geiger counter explorer with dead-end avoidance.
* ⚡ **Auto Provider** — Automated harvester for provider blocks (ATM Machine, Science Station, etc.).
* 🧪 **Auto Combine** — Automated laboratory recipe combiner.
* 💤 **AFK Bot** — Anti-AFK intelligent movement and reconnection helper.
* 🌍 **World Tools** — Automated world builder, dirt clearer, and door configuration tools.

---

## ⌨️ Complete In-Game Command Center

Type these commands directly into the Growtopia in-game chat:

### 🖥️ Core & System
| Command | Description |
| :--- | :--- |
| `/menu`, `/help` | Open main WinProxy dialog menu |
| `/cmd` | Open full Command Center dialog |
| `/proxy`, `/imgui` | Toggle visual ImGui panel overlay |
| `/settingmenu` | Open script settings & preferences |
| `/aliasmenu` | Open custom command alias manager |
| `/g`, `/ghost` | Fast shortcut for `/ghost` |
| `/res` | Fast shortcut for character respawn |
| `/re` | Fast shortcut to rejoin the current world |
| `/relog` | Fast shortcut to reconnect to the game server |

### 📞 Telephone & Auto-Buy
| Command | Description |
| :--- | :--- |
| `/cvdl` | Auto convert Diamond Locks to Blue Gem Locks |
| `/buybgl` | Auto buy Blue Gem Lock via telephone |
| `/buydl` | Auto buy Diamond Lock via telephone |
| `/buychamp` | Auto buy Champagne using World Locks |
| `/buychampbg` | Auto buy Champagne using Black Gems |
| `/buychampbulk` | Auto buy bulk Champagne |
| `/telemenu` | Open Telephone shortcut menu dialog |

### 💰 Economy & Fast Drop
| Command | Description |
| :--- | :--- |
| `/dw <qty>` | Fast auto-drop World Lock |
| `/dd <qty>` | Fast auto-drop Diamond Lock |
| `/db <qty>` | Fast auto-drop Blue Gem Lock |
| `/dbl <qty>` | Fast auto-drop Black Gem Lock |
| `/daw` | Fast drop all locks in backpack instantly |
| `/depo <qty>` | Deposit BGL directly into bank |
| `/with <qty>` | Withdraw BGL directly from bank |
| `/blue` | Convert Black GL to Blue GL |
| `/black` | Convert Blue GL to Black GL |

### 🧲 Auto Pull & Wrench Controls
| Command | Description |
| :--- | :--- |
| `/autopull` | Toggle Master Auto Pull on/off |
| `/posautopull` | Set Auto Pull target tile to your current position |
| `/clearposautopull` | Reset Auto Pull target back to White Door |
| `/autopullmenu` | Open Auto Pull configuration dialog |
| `/apblacklist add <uid>` | Add a player UID to pull blacklist |
| `/apblacklist remove <uid>` | Remove a player UID from blacklist |
| `/apblacklist list` | Display the current blacklist in chat |
| `/wrp`, `/wrps` | Auto Pull target on wrench (Left Click / Right Click) |
| `/wrk`, `/wrks` | Auto Kick target on wrench (Left Click / Right Click) |
| `/wrb`, `/wrbs` | Auto World Ban target on wrench (Left Click / Right Click) |
| `/wrt`, `/wrts` | Auto Trade target on wrench (Left Click / Right Click) |
| `/showbal` | Toggle fast balance display on player inspect |

### 🎰 Casino & Calculator
| Command | Description |
| :--- | :--- |
| `/casinomenu` | Open Casino master control dialog |
| `/allmode` | Toggle All mode (Reme, Leme, Qeme) |
| `/reme`, `/qeme` | Toggle Reme / Qeme calculator mode |
| `/leme`, `/lemes` | Toggle Leme / Leme S calculator mode |
| `/ceme` | Toggle Ceme calculator mode |
| `/lewa <num>` | Set Lewa multiplier and enable mode |
| `/calc <formula>` | Calculate math instantly (e.g. `/calc 50*12/2`) |
| `/calcmenu` | Open Calculator dialog menu |

### 🎁 Smart Donation & Trade
| Command | Description |
| :--- | :--- |
| `/dmode` | Toggle Smart Donation mode on/off |
| `/donatemenu` | Open Donation configuration dialog |
| `/pw <qty>` | Remote donate World Locks to box |
| `/pd <qty>` | Remote donate Diamond Locks to box |
| `/pb <qty>` | Remote donate Blue Gem Locks to box |
| `/pbl <qty>` | Remote donate Black Gem Locks to box |
| `/pall` | Remote donate all locks in your backpack |
| `/takeall` | Retrieve all items from donation box |
| `/tmode` | Toggle Trade Wrench mode |
| `/tw <qty>` | Fast add World Locks to active trade |
| `/td <qty>` | Fast add Diamond Locks to active trade |
| `/tb <qty>` | Fast add Blue Gem Locks to active trade |
| `/tbl <qty>` | Fast add Black Gem Locks to active trade |
| `/tall` | Fast add all locks in backpack to trade |
| `/tclear` | Clear all locks from active trade window |

### 🛡️ General Proxy Features
| Command | Description |
| :--- | :--- |
| `/antilag` | Toggle anti-lag (particle/shadow suppression) |
| `/modfly` | Toggle flying mode (noclip) |
| `/antipickup` | Toggle anti-pickup items protection |
| `/antiportal` | Toggle anti-portal warp bypass |
| `/nightvision` | Toggle full map night vision |
| `/fastdrop` | Toggle fast drop without confirmation dialog |
| `/fasttrash` | Toggle fast trash without confirmation dialog |
| `/autocv` | Toggle auto-convert locks on item collection |
| `/modal` | Calculate and display your own total balance |
| `/tp` | Toggle Teleport Punch (Display/Vend) |
| `/blocksdb` | Toggle blocking of SDB popup dialogs |
| `/vendfilter` | Formats large World Lock prices in vends |
| `/donfilter` | Shows actual item icons in Donation Boxes |
| `/sboxfilter` | Enable Storage Box Xtreme Take-All mode |

### 📢 Auto-Spam & Broadcast
| Command | Description |
| :--- | :--- |
| `/spam` | Toggle auto-spam messenger on/off |
| `/spammenu` | Open Auto-Spam UI configuration dialog |
| `/addspam <txt>` | Add a new message to spam rotation |
| `/removespam` | Remove the last message from spam rotation |
| `/spamtext <idx> <txt>` | Edit a specific spam rotation line |
| `/sbmenu` | Open Super Broadcast (SB & SDB) control dialog |
| `/sbstart`, `/sbstop` | Start / Stop automated Super Broadcast |
| `/sdbstart`, `/sdbstop` | Start / Stop automated Super Duper Broadcast |

### 🎨 Customization & Logs
| Command | Description |
| :--- | :--- |
| `/emojimenu` | Open chat emoji and color styling menu |
| `/emoji` | Toggle random chat emojis prefix |
| `/watermark` | Toggle `[@Win]` chat watermark prefix |
| `/encrypt` | Toggle chat encryption mode |
| `/logsmenu` | Open master activity logs dialog |
| `/logs` | Toggle activity logging on/off |
| `/clogs` | Open Collect detailed logs |
| `/dlogs` | Open Drop detailed logs |
| `/invlogs` | Open Inventory detailed logs |
| `/slogs` | Open Casino & Spin detailed logs |

### 👑 BTK & BJ Host Games
| Command | Description |
| :--- | :--- |
| `/btkmenu`, `/bjmenu` | Open host game dialog panel |
| `/btkcmd`, `/bjcmd` | Open BTK / BJ host commands cheat-sheet |
| `/btk`, `/bj` | Switch host game mode (BTK or BJ) |
| `/btkremote`, `/bjremote` | Collect remote from Magplant |
| `/btkbet`, `/bjbet` | Take player bets & calculate host tax |
| `/btkgems`, `/bjgems` | Check gems count & announce winner |
| `/btkdrop`, `/bjdrop` | Drop prize pool, host tax & reset round |
| `/btkcenter`, `/bjcenter` | Touch/punch tile to set host center position |
| `/btkposbet1`, `/bjposbet1` | Touch/punch tile to set Player 1 bet position |
| `/btkposbet2`, `/bjposbet2` | Touch/punch tile to set Player 2 bet position |
| `/btkposbreak1`, `/bjposbreak1` | Touch/punch tile to set Player 1 break position |
| `/btkposbreak2`, `/bjposbreak2` | Touch/punch tile to set Player 2 break position |
| `/btktax`, `/bjtax` | Touch/punch tile to set host tax drop position |
| `/btkmag`, `/bjmag` | Touch/punch tile to set host Magplant position |

---

## 🔒 Security & Whitelist Authentication

WinProxy operates on a secure UID authentication system:
1. When executed, WinProxy retrieves your Growtopia UID.
2. The script validates your UID against the official cloud whitelist (`uids.txt`).
3. If whitelisted, access is granted instantly and your session is authenticated.
4. An encrypted notification is dispatched to the Win Community Discord bot for activity logging and licensing verification.

---

## 💬 Community & Support

Need assistance or looking to purchase access?
* Join the **Win Community Discord Server**.
* Contact **MrLan** or official Win Community admins for support.

© 2026 **Win Community**. All rights reserved.
