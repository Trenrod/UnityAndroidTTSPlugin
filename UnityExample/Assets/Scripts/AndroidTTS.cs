using UnityEngine;
using TMPro;
using Unity.VisualScripting;
using System;

public class AndroidTTS : MonoBehaviour
{
	public TextMeshProUGUI logView;

	private AndroidJavaObject ttsPlugin;

	// Start is called once before the first execution of Update after the MonoBehaviour is created
	void Start()
	{
		try
		{
			AddToLog("[AndroidTTS:Start] Started");

			AddToLog("[AndroidTTS:Start] Create TTSPlugin class");
			ttsPlugin = new("com.trenrod.unity.androidttsplugin.TTSPlugin");

			AddToLog("[AndroidTTS:Start] Create class reference to UnityPlayer");
			AndroidJavaClass unityPlayer = new("com.unity3d.player.UnityPlayer");

			AddToLog("[AndroidTTS:Start] Call initalize method and pass currentActivity provided by UnityPlayer");
			ttsPlugin.Call("initialize", unityPlayer.GetStatic<AndroidJavaObject>("currentActivity"));
			ReadAndroidLogs();
		}
		catch (System.Exception error)
		{
			AddToLog("[AndroidTTS:Start] Failed to start. Error: " + error.Message);
		}
	}

	// Update is called once per frame
	void Update()
	{

	}

	void AddToLog(string message)
	{
		logView.text = logView.text + '\n' + message;
	}

	public void ReadText()
	{
		if (ttsPlugin != null)
		{
			try
			{
				AddToLog("[AndroidTTS:ReadText] Calling speak");
				ttsPlugin.Call<bool>("speak", "Hi this is a TTS example");
				ReadAndroidLogs();
			}
			catch (System.Exception error)
			{
				AddToLog("[AndroidTTS:ReadText] Failed calling speak. " + error.Message);
				ReadAndroidLogs();
			}
		}
		else
		{
			AddToLog("[AndroidTTS:ReadText] Plugin not initialised");
		}
	}

	public void ReadAndroidLogs()
	{
		if (ttsPlugin != null)
		{
			AndroidJavaObject logs = ttsPlugin.Call<AndroidJavaObject>("getLogs");
			int count = logs.Call<int>("size");
			for (int i = 0; i < count; i++)
			{
				AddToLog("AndroidTTS:ReadAndroidLogs] " + logs.Call<string>("get", i));
			}
		}
		else
		{
			AddToLog("[AndroidTTS:ReadAndroidLogs] Plugin not initialised");
		}
	}
}
