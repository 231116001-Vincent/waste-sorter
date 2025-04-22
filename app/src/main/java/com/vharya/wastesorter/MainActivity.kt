package com.vharya.wastesorter

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gridView = 
    }

//    Light & Dark mode color solution example (thx gpt)
//    fun getCategoryColor(category: String, context: Context): Int {
//        return when (category) {
//            "Recyclable" -> ContextCompat.getColor(context, R.color.recyclable_light)
//            "Organic" -> ContextCompat.getColor(context, R.color.organic_light)
//            "Hazardous" -> ContextCompat.getColor(context, R.color.hazardous_light)
//            else -> ContextCompat.getColor(context, android.R.color.darker_gray)
//        }
//    }
}