# 🎮 WINPROXY — Proxy CreativePS

**WinProxy** is an all-in-one proxy script for **Growtopia Private Server (CreativePS)** that runs on the **BotHax** executor. It comes with a **UID authentication system** (whitelist) and **automatic Discord notifications** every time the script is executed.

> ⚠️ **Note:** This repository only contains the encrypted loader file. The source code is **not public**.

---

## 🚀 How to Use

1. Open the **BotHax** executor
2. Execute the **`WinProxy Loader.lua`** file (one-time setup, auto-updates)
3. Type **`/imgui`** to open the ImGui menu, or **`/menu`** for the in-game dialog menu
4. All settings are saved automatically in `WinCommunity_Config.txt`

---

## ✨ Features

| Category | Features |
|----------|----------|
| 🛡️ **General** | Anti-Pickup, Block SDB, Auto Pull + Blacklist, Teleport Punch, Show Balance, Fast Drop/Trash, Vend Filter, Donation Filter |
| 🔧 **Wrench** | Auto Pull / Kick / Ban / Trade on wrenched player |
| 💰 **Donate** | Smart Donation Box (remote donate WL/DL/BGL/BlackGL, take all) |
| 🤝 **Trade** | Fast add WL/DL/BGL/BlackGL to trade |
| 📞 **Telephone** | Auto Convert DL→BGL, Auto Buy BGL/DL/Champagne |
| 🎰 **Casino** | Reme, Qeme, Leme, Leme S, Ceme, Lewa (with multiplier) |
| 🧮 **Calculator** | Instant math calculator via chat |
| 🎨 **Emoji & Color** | Random emojis, chat watermark, chat colors, rainbow/blink skin |
| 📦 **Item Database** | Search item info |
| 🎣 **Auto Fish** | Auto cast, auto bite, statistics |
| 🏥 **Auto Surg** | Auto surgery + auto modage bypass |
| 🦹 **Auto Crime** | Auto fight crime + auto buy cards |
| 📢 **Auto Spam** | Multi-line spam with interval |
| 📡 **Super Broadcast** | SB & SDB automation + Discord webhook |
| 📜 **All Logs** | Activity, casino, inventory, collect/drop logs |
| 🛒 **Auto Buy Pack** | Auto scan & buy packs, batch mode, drop items |
| ⚙️ **Setting** | Save/load configuration |

> ⏳ **Coming Soon:** Auto Farm (PTHT/Splice/PNB/Rotasi/Tax), Auto Cook, Auto Geiger, BTK/BJ, Magplant, Vending, AFK, World

---

## ⌨️ Complete Command List

### 🖥️ System & Tools
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

### 🛡️ General
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

### 🔧 Wrench
| Command | Description |
|---------|-------------|
| `/wrenchmenu` | Open wrench menu |
| `/wrp` | Toggle auto pull on wrenched player |
| `/wrk` | Toggle auto kick on wrenched player |
| `/wrb` | Toggle auto ban on wrenched player |
| `/wrt` | Toggle auto trade on wrenched player |

### 💰 Donate
| Command | Description |
|---------|-------------|
| `/donatemenu` | Open donate menu |
| `/dmode` | Toggle smart donation mode |
| `/pw <qty>` | Donate World Lock |
| `/pd <qty>` | Donate Diamond Lock |
| `/pb <qty>` | Donate Blue Gem Lock |
| `/pbl <qty>` | Donate Black Gem Lock |
| `/takeall` | Retrieve all items from donation box |

### 🤝 Trade
| Command | Description |
|---------|-------------|
| `/trademenu` | Open trade menu |
| `/tw <qty>` | Fast add World Lock to trade |
| `/td <qty>` | Fast add Diamond Lock to trade |
| `/tb <qty>` | Fast add Blue Gem Lock to trade |
| `/tbl <qty>` | Fast add Black Gem Lock to trade |

### 📞 Telephone
| Command | Description |
|---------|-------------|
| `/telemenu` | Open telephone menu |
| `/cvdl` | Auto convert DL to BGL |
| `/buybgl` | Auto buy Blue Gem Lock |
| `/buydl` | Auto buy Diamond Lock |
| `/buychamp` | Auto buy Champagne |

### 🎰 Casino
| Command | Description |
|---------|-------------|
| `/casinomenu` | Open casino menu |
| `/reme` | Toggle Reme mode |
| `/qeme` | Toggle Qeme mode |
| `/leme` | Toggle Leme mode |
| `/lemes` | Toggle Leme S mode |
| `/ceme` | Toggle Ceme mode |
| `/lewa <num>` | Set Lewa multiplier and enable |

### 🧮 Calculator
| Command | Description |
|---------|-------------|
| `/calcmenu` | Open calculator menu |
| `/calc <form>` | Calculate math instantly (e.g. `/calc 5*5+2`) |

### 📢 Auto Spam
| Command | Description |
|---------|-------------|
| `/spammenu` | Open spam menu |
| `/spam` | Toggle auto-spam |
| `/addspam <txt>` | Add a spam message |
| `/removespam` | Remove last spam message |
| `/spamtext <#> <txt>` | Edit specific spam line |

### 📡 Super Broadcast
| Command | Description |
|---------|-------------|
| `/sbmenu` | Open SB & SDB menu |
| `/sbstart` | Start Super Broadcast |
| `/sbstop` | Stop Super Broadcast |
| `/sdbstart` | Start Super Duper Broadcast |
| `/sdbstop` | Stop Super Duper Broadcast |

### 🎨 Emoji & Color
| Command | Description |
|---------|-------------|
| `/emojimenu` | Open emoji menu |
| `/emoji` | Toggle random chat emojis |
| `/watermark` | Toggle custom chat watermark |

### 📜 Logs
| Command | Description |
|---------|-------------|
| `/logsmenu` | Open logs menu |
| `/logs` | Toggle activity logging |
| `/clogs` | Open Collect Logs |
| `/dlogs` | Open Drop Logs |
| `/invlogs` | Open Inventory Logs |
| `/slogs` | Open Casino/Spin Logs |

### 💎 Economy & Drop
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

## 🔒 Security

- **UID Authentication** — only whitelisted users can run the script
- **Discord Notifications** — every access (granted/denied) is sent to a webhook with GrowID, UserID, World, IP, and timestamp
- **Auto-Update** — the script always fetches the latest version, no need to re-download

---

## 📌 Notes

- Some features marked *(Soon)* are still in development
- For custom commands, you can map your own shortcuts via the ImGui menu (e.g. `/di` → `/dbl`)
