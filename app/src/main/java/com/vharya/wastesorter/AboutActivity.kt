package com.vharya.wastesorter

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)
        WindowCompat.setDecorFitsSystemWindows(window, true)

        val buttonBack: ImageButton = findViewById(R.id.button_back)

        buttonBack.setOnClickListener { finish() }
    }
}