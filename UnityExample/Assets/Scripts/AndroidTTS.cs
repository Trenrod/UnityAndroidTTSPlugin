using UnityEngine;
using TMPro;
using Unity.VisualScripting;
using System;

public class AndroidTTS : MonoBehaviour
{
	public TextMeshProUGUI logView;

	private AndroidJavaClass TTSPlugin;

	// Start is called once before the first execution of Update after the MonoBehaviour is created
	void Start()
	{
		addToLog("AndroidTTS:Start: Started");
		AndroidJavaObject ttsPlugin = new AndroidJavaObject("com.trenrod.unity.androidttsplugin.TTSPlugin");
		ttsPlugin.Call("initialize");
		AndroidJavaObject logs = ttsPlugin.Call<AndroidJavaObject>("getLogs");
		Debug.Log(logs.GetType());
	}

	// Update is called once per frame
	void Update()
	{

	}

	void addToLog(string message)
	{
		logView.text = logView.text + '\n' + message;
	}
}
