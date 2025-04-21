# Create Unity Project and use Android TTS module

## Create Unity project

- Open `Unity Hub`
- Make sure your Editor Version is `6000.0 LTS`
- Select `New project`
- In `New project` view. Select `Core` and then `Universal 3D`
- Select `Create project`

## Create UI components for debugging

Similar to what we did in Android Studio example app. We will add a debug view and a button to trigger speak.

- Checkout scene `Canvas`

## Add module

- Create directory `Asset -> Plugin -> Android`
- Copy compiles `aar` from our AndroidTTSPlugin module. `\UnityPlugin\AndroidTTSPlugin\build\outputs\aar\AndroidTTSPlugin-debug.aar` to `Assets -> Plugin -> Android`

## Unity code to access Plugin

On how to call Android AAR from C# Unity checkout. [Call Java and Kotlin plug-in code from C# scripts](https://docs.unity3d.com/Manual/android-plugins-java-code-from-c-sharp.html)

- Create `Empty gameobject` by pressing `Cntr+Shit+N` and name it `TTSGameObject`
- Create new Monobehavior in `Assets -> Scripts -> AndroidTTS`
- Add `AndroitTTS.cs` file to `TTSGameObject`
- Checkout [AndroitTTS.cs](../UnityExample/Assets/Scripts/AndroidTTS.cs) for detailed implementation



