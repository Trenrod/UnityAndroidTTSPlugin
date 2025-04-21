# UnityAndroidTTSPlugin

This project should explain in detail how to create a UnityAndroid Plugin using TTS (Text-To-Speech) on Android natively.
 - contains an Unity 6 and Android Studio Android Studio 2024.3.1 Patch 1 project (will branch this project once a new Unity version is available)
- detailed step-by-step description on how to use them.
- detailed step-by-step description on how to create your own.

## Project structure

- `/doc/`: Documentations
- `/UnityPlugin/`: Android Studio project
	- `AndroidTTSPlugin/`: Module to access TTS. Can exported `aar` which used as a plugin in Unity to access native TTS.
	- `app/`: Example application to test `AndroidTTSPlugin` directly from an Android Studio emulator
- `/UnityExample/`: Unity 6 project
	- TBD

## Usage

## Step by step guide on how to create each project

Those guides are recommended for getting started to create your own implementation.

### [Create Android Module](./doc/create_android_module_for_unity_6.md)

### [Create Unity Project and use Android TTS module](./doc/create_unity_6_example_for_module_use.md)

## Kudos

- [@Voitanium](https://www.youtube.com/@Voitanium) - [Creating Android Plugin (AAR) for Unity with Android Toast](https://www.youtube.com/watch?v=6u7FV-e6nUc&list=PLgdJs67VIHij7g5vf-AYChkSNn8X73ECS) (YouTube)