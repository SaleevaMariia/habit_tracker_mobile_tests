# Autotests for mobile application https://github.com/iSoron/uhabits

## Covered features:

- [x] going through welcome page
- [x] adding new Yes/No habit (positive and negative tests)
- [x] adding new measurable habit (positive and negative tests)

## Technology Stack:

![java](./img/icons/Java.png "Java")
![gradle](./img/icons/Gradle.png "Gradle")
![jUnit5](./img/icons/JUnit5.png "JUnit5")
![selenide](./img/icons/Selenide.png "Selenide")
![appium](./img/icons/Appium.png "Appium")
![jenkins](./img/icons/Jenkins.png "Jenkins")
![Selenoid](./img/icons/Selenoid.png "Selenoid")
![browserstack](./img/icons/Browserstack.png "Browserstack")
![allure-logo](./img/icons/Allure_Report.png "Allure_Report")
![telegram-logo](./img/icons/Telegram.png "Telegram")

Java, Gradle, JUnit5, Selenide, Appium, Jenkins, Selenoid, Browserstack, Allure Reports, Telegram (уведомления)

## Description

You can run tests by configuring the following parameters:

- deviceHost
  ![Parametrised build](./img/run_jenkins.png)

### To run tests locally with files emulator.properties or realDevice.properties:

```
gradle clean test -DdeviceHost=emulator or -DdeviceHost=realDevice
```

### To run tests locally without files emulator.properties and realDevice.properties:

```
gradle clean test -DdeviceHost=emulator or -DdeviceHost=realDevice
 -DplatformName=Android
 -DdeviceName=Pixel_4_API_30
 -Dversion = 11.0
 -DappPackage=org.isoron.uhabits
 -DappActivity=org.isoron.uhabits.MainActivity
 -Dapp=src/test/resources/loop-2.0.3-release.apk
``` 

### To run tests on Selenoid without file selenoid.properties

```
gradle clean test -DdeviceHost=selenoid
 -DplatformName=Android
 -DdeviceName=android 
 -Dversion=8.1
 -DappPackage=org.isoron.uhabits
 -DappActivity=org.isoron.uhabits.MainActivity
 -Dapp=src/test/resources/loop-2.0.3-release.apk
```

### To run tests on BrowserStack without file browserstack.properties

```
gradle clean test -DdeviceHost=browserstack
   -Duser=
   -Dpassword=
   -Dapp=
   -Ddevice=Google Pixel 3
   -Dos_version=9.0
   -Dproject=habits
   -Dbuild=Java Android
   -Dname=add habits
```

## Allure reports

### Overview

![overview allure](./img/allure_overview.png)

### Test with steps, attached image, console logs

![selenoid_screen](./img/selenoid_screen.png)

### Video

![video](./img/video.mp4)
