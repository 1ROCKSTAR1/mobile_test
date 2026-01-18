# 🎯 Mobile HomeWork

<div align="center">

<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Java.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/JUnit5.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Gradle.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Intelij_IDEA.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Allure_Report.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/selenoid.png" width="60" height="50">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Jenkins.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/studio.jpg" width="82" height="95">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/appium.png" width="56" height="52">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/browserstack.png" width="56" height="52">

</div>

## 📚 Описание проекта

Учебный фреймворк для автоматизированного тестирования мобильных приложений. Проект реализует подход к тестированию UI слоя. Есть возможность запуска тестов на разных окружениях: browserstack servise или локально на эмуляторе.

## 🚀 Запуск тестов из терминала
Browserstack (gradle clean browserstack_tests)

Эмулятор (gradle clean emulator_tests)

# Структура проекта

    mobile_test/
    ├── 📁 src/
    │   └── 📁 test/
    │       ├── 📁 java/
    │       │   ├── 📁 android/
    │       │   │   ├── BaseBrowserstackTest.java
    │       │   │   └── BrowserstackTests.java
    │       │   ├── 📁 config/
    │       │   │   └── TestConfig.java
    │       │   ├── 📁 drivers/
    │       │   │   ├── BrowserStackAndroidDriver.java
    │       │   │   └── EmulatorDriver.java
    │       │   ├── 📁 emulator/
    │       │   │   ├── BaseEmulatorTest.java
    │       │   │   └── EmulatorTests.java
    │       │   ├── 📁 helpers/
    │       │   │   └── Attach.java
    │       │   └── 📁 wikipages/
    │       │       ├── ArticlePage.java
    │       │       ├── MainPage.java
    │       │       ├── MoreTab.java
    │       │       ├── SavedTab.java
    │       │       └── SettingsPage.java
    │       └── 📁 resources/
    │           └── 📁 apps/
    │               ├── app-alpha-universal-release.apk 
    │               ├── default.properties
    │               ├── local.properties
    │               └── new.properties
    ├── 📁 .idea/
    ├── 📄 .gitignore
    ├── 📄 build.gradle
    ├── 📄 gradlew
    ├── 📄 gradlew.bat
    ├── 📄 settings.gradle
    └── 📁 gradle/
      └── wrapper/
