package com.example.casinovirtual

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textView = TextView(this)
        textView.text = "🎰 Bienvenido a Casino Virtual! 🎲"
        textView.textSize = 24f
        setContentView(textView)
    }
}
