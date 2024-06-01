package com.example.interviewlist.kotlin


// https://en.wikipedia.org/wiki/Android_15

//Privacy Sandbox
//Health Connect
//File integrity
//Partial screen sharing
//In-app camera controls
//Dynamic Performance
//Sensitive notifications
//Notification cooldown


// https://en.wikipedia.org/wiki/Android_version_history

// Android 14 features

//User experience
//Building on the new option added in Android 13 to set languages individually for apps, this feature has been expanded and is easier to implement for developers. Furthermore, a new "Grammatical Inflection API" has been added to gender users according to their preferred grammatical gender.[11][12]
//
//Android 14 will provide the ability to increase the font size up to 200% compared to 130% in previous versions, combined with nonlinear font scaling to prevent large text elements on screen from scaling too large.[11] It is now possible to specify the temperature unit (Fahrenheit, Celsius, or Kelvin)[13] which should be used in applications.[14]
//
//The Material You design language, introduced in Android 12 and supplemented in Android 13, gets revised default colors in Android 14.[15] Android 14 also introduces additional lock screen customization options, such as multiple clock and weather styles.[16]
//
//For devices with a larger screen, such as tablets, the taskbar is expanded in Android 14 and now shows the names of the pinned apps.[15][17]
//
//Android 14 allows a phone to be configured as a webcam when plugged into a computer or another Android device.[18]
//
//Android 14 adds support for the new image format Ultra HDR, to take and display high dynamic range photos with HDR compatible cameras and displays. The Ultra HDR format is backwards compatible with JPEG on standard dynamic range displays.[19][20]
//
//Google rewrote parts of Android's Settings app to use its Jetpack Compose framework in Android 14.[21]
//
//Battery life
//Android system processes are more efficient, which provides battery life improvements.[12] In addition, there is now the option to choose directly between battery-saver mode and extreme battery-saver mode.[15]
//
//The screen time since the last full charge is now displayed in the battery settings. The battery consumption is shown separately from system and user applications. This feature was replaced with the launch of Android 12 by showing battery usage over the past 24 hours.[15][22]
//
//Privacy and security
//Android 14 blocks the installation of apps that target versions of Android below Marshmallow (6.0). The change is intended to curb the spread of malware, which intentionally targets old versions of Android to bypass security restrictions introduced in newer versions. An Android Debug Bridge (ADB) install flag has been added to bypass the restriction.[23][24]
//
//In order to improve privacy, the user can select which images an application may access, using a photo picker.[14]
//
//There is also a small change for guest mode or multiuser mode, where the "Allow guest to use phone" option has been moved to the top level menu. Previously, this option was behind the guest account itself.
//
//Health Connect
//Incorporating Health Connect as one of the new features of Android 14, users can now access it through the all-new Pixel's settings menu. Health Connect collaborates with apps like Fitbit, Samsung Health, and Google Fit.[25]
//

//===============================================================================

// Android 13 features

//Features
//Privacy
//Android 13 includes several new features intended to enhance user privacy, both user-facing and developer-facing.[13][14]
//
//A new media picker is added, which improves privacy by allowing users to choose which photos and videos apps have access to.[15] Most apps have not implemented this picker yet. In addition, Android 13 introduces a new permission, NEARBY_WIFI_DEVICES. Previously, Wi-Fi and GPS permissions were bundled into a single setting termed "Location". This change means that apps can now be allowed to search for nearby devices and networks without needing to request access to broader navigational systems.[16]
//
//Also, a new runtime permission feature is being added to apps sending non-exempt notifications which allows users to focus on notifications most important to them.[17]
//
//User experience
//Apps are now required to request permission from the user before they are able to send notifications.[18]
//
//Small changes to dialog windows such as the Internet toggle have been added, making them fit better with the design language. The media player has been redesigned, now using the album cover as a background, and including more user controls.[19] The multiple users feature has been improved, with the added option of selecting which apps can be accessed by the guest user. App data is sandboxed for each user, so no information is shared.
//
//New features
//The number of active apps is now shown at the bottom of the notifications panel; a tap on it opens a detailed panel which lets the user stop each of them.[20]
//
//Support for Bluetooth LE Audio and the LC3 audio codec, which enables receiving and sharing audio between multiple bluetooth devices simultaneously; it can also improve the audio quality and battery life of the connected devices, as long as they also support it.[15][21][22][23] This version opens the support for third-party apps to use themed "Material You" icons.[15] Long-pressing and dragging a notification will allow the notification to open in split screen view. This feature is available on phones as well as tablets.[18] Android 13 also adds support for WiFi 7, which is intended to decrease latency, buffering, lag and congestion.[24][25]
//
//As of Beta 2, the Pixel Launcher includes a new "unified" search bar, which is able to provide search results from the internet as well as local apps and activities. It seems that Google will be expanding the capabilities of this search tool in future releases.[26]
//
//Android 13 allows users to change the language for a specific app, rather than doing so for the entire software. One instance of this feature is changing the language in the YouTube app from American English to Spanish.[27]
//
//Tweaks
//Split Screen mode now persists through app changes, meaning it is possible to use other apps and the phone launcher, and split screen apps will stay paired together in the Overview menu. Animations have been improved, notably the fingerprint scanner glow on the Pixel 6 series. Overflow notifications on the lock screen also are housed in a dynamically sized pill rather than a bar, and the 2-line stacked clock is slightly smaller.[18] The app label font has been changed in the Pixel Launcher, and subtle haptics have been added throughout the user experience. The Android version has been changed to "Tiramisu" in settings and the Quick Settings panel. As of Developer Preview 2, "Tiramisu" is replaced with "13". The unified search bar includes new smoother animations and transitions.
//
//Many of the changes are from Android 12.1 "12L", such as the dock displayed on large screens, and other improvements for large format devices. These are mainly intended for foldables and tablets, but they can be enabled on phones by changing the DPI settings.
//