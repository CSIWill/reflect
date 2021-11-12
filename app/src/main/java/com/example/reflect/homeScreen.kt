package com.example.reflect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class homeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        //initialize
        val mButton = findViewById<Button>(R.id.beginBtn) as Button
            mButton.setOnClickListener{
                startActivity(Intent(this@homeScreen, Mood::class.java))
            }

        val reviewBtn = findViewById<Button>(R.id.button2)
            reviewBtn.setOnClickListener{
                setContentView(R.layout.review_entry)
                startActivity(Intent(this@homeScreen, reviewScreen::class.java))
            }
    }
}