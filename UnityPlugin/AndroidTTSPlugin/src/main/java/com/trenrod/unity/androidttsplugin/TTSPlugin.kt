package com.trenrod.unity.androidttsplugin

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

/**
 * TTSPlugin is a wrapper class for Android's TextToSpeech functionality.
 * It provides a simple interface for text-to-speech operations and includes logging capabilities.
 *
 * Lifecycle:
 * 1. Create an instance of TTSPlugin
 * 2. Call initialize(context) to start the TTS engine
 * 3. Wait for onInit callback to confirm successful initialization
 * 4. Use TTS functionality while isInitialized is true
 * 5. The class maintains its own logging system for debugging purposes
 */
class TTSPlugin : TextToSpeech.OnInitListener {

    /** The TextToSpeech instance. Null until initialized. */
    private var tts: TextToSpeech? = null

    /** Flag indicating whether TTS has been successfully initialized. */
    private var isInitialized = false

    /** Collection of log messages for debugging purposes. */
    var logs: MutableList<String> = mutableListOf()

    /**
     * Initializes the TextToSpeech engine with the provided context.
     * This method must be called before using any TTS functionality.
     * The initialization is asynchronous, and success/failure will be reported via onInit.
     *
     * @param context The Android Context required for TTS initialization
     */
    fun initialize(context: Context) {
        addLog("TTSPlugin:initialize", "Initializing TTS...")
        tts = TextToSpeech(context, this)
    }

    /**
     * Callback method called by the TextToSpeech engine when initialization is complete.
     * This method is part of the TextToSpeech.OnInitListener interface.
     *
     * @param status The status of the initialization. TextToSpeech.SUCCESS indicates successful initialization.
     */
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            isInitialized = true
            addLog("TTSPlugin:onInit", "TTS initialized successfully")
        } else {
            addLog("TTSPlugin:onInit", "Failed to initialize TTS")
        }
    }

    /**
     * Adds a log message to the internal log cache.
     * Each log entry is formatted as "tag: message".
     *
     * @param tag The category or source of the log message
     * @param message The actual log message content
     */
    private fun addLog(tag: String, message: String) {
        logs.add("$tag: $message")
    }

    /**
     * Retrieves all accumulated logs and clears the log cache.
     * This method is useful for debugging and monitoring the TTS plugin's state.
     *
     * @return ArrayList<String> containing all log messages in chronological order
     */
    fun getLogs(): ArrayList<String> {
        val result = ArrayList(logs)
        logs.clear()
        return result
    }

    /**
     * Speaks the provided text using the TextToSpeech engine.
     * If TTS is not initialized, the request will be logged and ignored.
     *
     * @param text The text to be spoken
     * @return Boolean indicating whether the speak request was successfully queued
     */
    fun speak(text: String): Boolean {
        if (!isInitialized) {
            addLog("TTSPlugin:speak", "Cannot speak: TTS not initialized")
            return false
        }

        return try {
            tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
            addLog("TTSPlugin:speak", "Speaking text: $text")
            true
        } catch (e: Exception) {
            addLog("TTSPlugin:speak", "Error speaking text: ${e.message}")
            false
        }
    }
}
