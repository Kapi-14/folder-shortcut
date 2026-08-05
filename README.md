# Folder Shortcut (Android App)

**Folder Shortcut** is a clean, utility Android application that allows users to create customized home screen shortcuts for any folder on their device storage.

## 🚀 Key Features

- 📁 **Custom Folder Shortcuts**: Create quick-access home screen shortcuts for any directory (internal storage or Storage Access Framework - SAF).
- 🎨 **Icon Studio**:
  - Choose from preset folder icons (Music, Video, Photos, Documents, Code, Vault, Games, Cloud, Star, Zip, etc.).
  - Select custom personal images as folder icons.
  - Customize background colors and icon tint colors.
  - Apply custom shape masks (Circle, Hexagon, Original, Rounded, Squircle, Star).
- 📂 **Built-in Folder Browser**: Tap shortcuts to launch a clean, built-in file viewer with back-stack navigation.
- ⚡ **Seamless Android Integration**: Uses Android `ShortcutManager` and `INSTALL_SHORTCUT` API for 1-tap pinning.

## 🛠️ Tech Stack & Architecture

- **Language**: Kotlin / Java
- **Package**: `com.foldershortcut.app`
- **Target SDK**: Android 14 (API 34)
- **UI Framework**: AndroidX, Material Design 3, ViewBinding, RecyclerView
- **Permissions**: `READ_EXTERNAL_STORAGE`, `MANAGE_EXTERNAL_STORAGE`, `INSTALL_SHORTCUT`

## 💻 How to Build & Run

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/folder-shortcut.git
   ```
2. Open the project folder in **Android Studio**.
3. Sync Gradle dependencies.
4. Build and run on an Android device or emulator.

## 🤝 Contributing

Contributions are welcome!
1. Fork the repo
2. Create your feature branch (`git checkout -b feature/NewFeature`)
3. Commit changes (`git commit -m 'Add NewFeature'`)
4. Push to branch (`git push origin feature/NewFeature`)
5. Open a Pull Request

## 📄 License

Distributed under the MIT License.
