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
  - Module name: *AndroidTSSPlugin*
  - Package name: *com.trenrod.unity.androidtssplugin*
  - Language: *Kotlin*
  - Minimum SDK: *API 23 ("Marshmallow"; Android 6.0)* <-- This is required by Unity 6
  - Build Configuration Language: *Kotlin DSL ...*
- Select `Finish`
- Wait till project has been finally set up.

## Test if module is created successfully

- Open Terminal (`Alt+F12`)
- Test if build is working type: `.\gradlew build -x test` to run build without tests.
- Test if module can be created type: `.\gradlew assembleDebug`
- Check if `AndroidTSSPlugin-debug.aar` has been created
  - Still in terminal execute `explorer .`
  - Goto `AndroidTSSPlugin\build\outputs\aar` look for `AndroidTSSPlugin-debug.aar`

## Implement a TTS Module

We will create a Class called `AndroidTTSPlugin` inside AndroidTSSPlugin which offers a function `readText`.



## Test Unity Android TTS Module

We will adjust the initial `Empty View Actity` to use our created Module to test it.
