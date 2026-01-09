# 🎯 Mobile HomeWork

<div align="center">

<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Java.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/JUnit5.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Gradle.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Intelij_IDEA.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Allure_Report.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/selenoid.png" width="60" height="50">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Jenkins.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/appium.png" width="56" height="52">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/browserstack.png" width="56" height="52">

</div>

## 📚 Описание проекта

Учебный фреймворк для автоматизированного тестирования мобильных приложений. Проект реализует подход к тестированию UI слоя, интегрирован в CI/CD pipeline и оснащен системой отчетности.

# Структура проекта

    mobile_test/
    ├── 📁 src/
    │   └── 📁 test/
    │       ├── 📁 java/
    │       │   ├── 📁 android/
    │       │   │   ├── BaseAndroidTest.java
    │       │   │   ├── ImprovedSearchTests.java
    │       │   │   └── TestConfig.java
    │       │   ├── 📁 drivers/
    │       │   │   ├── BrowserStackAndroidDriver.java
    │       │   │   └── LocalDriver.java
    │       │   ├── 📁 emulator/
    │       │   │   ├── BaseEmulatorTest.java
    │       │   │   └── Tests.java
    │       │   ├── 📁 helpers/
    │       │   │   └── Attach.java
    │       │   └── 📁 wikipages/
    │       │       ├── ArticlePage.java
    │       │       └── MainPage.java
    │       └── 📁 resources/
    │           └── 📁 apps/
    │               ├── app-alpha-universal-release.apk 
    │               ├── new.properties
    │               └── old.properties
    ├── 📁 .idea/
    ├── 📄 .gitignore
    ├── 📄 build.gradle
    ├── 📄 gradlew
    ├── 📄 gradlew.bat
    ├── 📄 settings.gradle
    └── 📁 gradle/
      └── wrapper/
