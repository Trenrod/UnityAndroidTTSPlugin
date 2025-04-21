package com.trenrod.unity.unityplugin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.trenrod.unity.androidttsplugin.TTSPlugin

class MainActivity : AppCompatActivity() {
    private lateinit var ttsPlugin: TTSPlugin
    private lateinit var logView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        logView = findViewById(R.id.logView)
        val buttonSpeak = findViewById<Button>(R.id.buttonSpeak)
        // Initialize TTS Plugin
        ttsPlugin = TTSPlugin()
        ttsPlugin.initialize(this)
        ttsPlugin.addLog("MainActivity", "TTS Plugin initialized")
        printLogs()

        // Set up button click listener
        buttonSpeak.setOnClickListener {
            ttsPlugin.addLog("MainActivity", "Speak button clicked")
            printLogs()
            ttsPlugin.speak("Hello from TTS Plugin!")
            printLogs()
        }
    }

    private fun printLogs() {
        ttsPlugin.getLogs().forEach { log ->
            val currentText = logView.text.toString()
            val newText = if (currentText.isEmpty()) log else "$currentText\n$log"
            logView.text = newText
        }
    }
}
