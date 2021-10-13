package com.example.reflect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Mood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood)

        val mButton = findViewById<Button>(R.id.enterMoodBtn) as Button
        mButton.setOnClickListener{
            startActivity(Intent(this@Mood, MainActivity::class.java))
        }
    }
}