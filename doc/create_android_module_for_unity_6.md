# Create Android Module for Unity 6

## Create Android project

- Create `New Project`
- In `New Project` view. Select `Empty Views Activity` and press `Next`
- In `New Project`, `Empty Views Activity` view. 
  - Name: *UnityPlugin*
  - Packagename: *com.trenrod.unity.unityplugin* <-- Use your own here
  - Save location: *X:\dev\UnityAndroidTTSPlugin\UnityPlugin*
  - Minimum SDK: *API 23 ("Marshmallow"; Android 6.0)* <-- This is required by Unity 6
- Select `Finish`
- Wait till project has been finally set up.

Notes:
- Using `Empty Activity` showed Errors after creation. Maybe this combination is not supported.

## Test if project is created successfully

- `Alt+\` -> `Run` -> `Run app`
- Wait till emolator is opened
- Wait till app is started
- Check if `Hello world` is displayed

## Create Android TTS Plugin for Unity

This module will then be exported as `AAR` file and used in unity.

- `Alt-\` -> `File` -> `New` -> `New Module...`
- In `Create new Module`. Select `Android librarby`
- On the right side configute:
  - Module name: *AndroidTTSPlugin*
  - Package name: *com.trenrod.unity.AndroidTTSPlugin*
  - Language: *Kotlin*
  - Minimum SDK: *API 23 ("Marshmallow"; Android 6.0)* <-- This is required by Unity 6
  - Build Configuration Language: *Kotlin DSL ...*
- Select `Finish`
- Wait till project has been finally set up.

## Test if module is created successfully

- Open Terminal (`Alt+F12`)
- Test if build is working type: `.\gradlew build -x test` to run build without tests.
- Test if module can be created type: `.\gradlew assembleDebug`
- Check if `AndroidTTSPlugin-debug.aar` has been created
  - Still in terminal execute `explorer .`
  - Goto `AndroidTTSPlugin\build\outputs\aar` look for `AndroidTTSPlugin-debug.aar`

## Implement a TTS Module

We will create a Class called `AndroidTTSPlugin` inside AndroidTTSPlugin which offers a function `readText`.

- As requested in the [API reference TextToSpeech](https://developer.android.com/reference/kotlin/android/speech/tts/TextToSpeech) declare `android.speech.tts.TextToSpeech.Engine#INTENT_ACTION_TTS_SERVICE` in the queries element of `UnityAndroidTTSPlugin\UnityPlugin\AndroidTTSPlugin\src\main\AndroidManifest.xml`.
- The result should look like this file: [AndroidManifest.xml](../UnityPlugin/AndroidTTSPlugin/src/main/AndroidManifest.xml)
- Create class to use TTS. `Right-Click` on `AndroidTTSPlugin -> kotlin+java -> com.trenrod.unity.androidttsplugin` on the left side file explorer view. Then `New` -> `Kotlin class/file`.
- In `New Kotlin Class/File`. Select `Class` and name it `TTSPlugin`.
- Checkout the detailed comments in [TTSPlugin](../UnityPlugin/AndroidTTSPlugin/src/main/java/com/trenrod/unity/androidttsplugin/TTSPlugin.kt) about the implementation.

## Test Unity Android TTS Module in Android Studio emulator

We will adjust the initial `Empty View Actity` to use our created Module to test it. 

This allows us to quickly test our Module before implementing the Unity part.

- Make the module available in our Main App (UnityPlugin/app)
	- Open `Project structure` view with `Alt+\ -> File -> Project structure`
	- Select `Dependencies`. 
	- Select `app` under `Modules`.
	- Select `+` under `Declared Dependencies`
	- Select `3 Module Dependency` 
	- In the `Add Module Dependency` View. Select `AndroidTTSPlugin` and press `OK`
	- Back in `Project structure` view press `Apply` and once applied press `OK`
- Checkout simple UI (logview and button) to allow testing our Module [activity_main.xml](`../UnityPlugin\app\src\main\res\layout\activity_main.xml`)
- Checkout the detailed comments in [activity_main.xml](../UnityPlugin/app/src/main/java/com/trenrod/unity/unityplugin/MainActivity.kt) on how to use the Module.
