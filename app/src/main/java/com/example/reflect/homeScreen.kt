package com.example.reflect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.ImageButton

class homeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        //initialize
        val mButton = findViewById<Button>(R.id.beginBtn) as Button
            mButton.setOnClickListener{
                startActivity(Intent(this@homeScreen, Mood::class.java))
            }
        val reviewBtn = findViewById<Button>(R.id.reviewButton)
        reviewBtn.setOnClickListener{
            startActivity(Intent(this@homeScreen, ReviewScreen::class.java))
        }


        val nButton = findViewById<ImageButton>(R.id.notifImageButton) as ImageButton
        nButton.setOnClickListener{
            startActivity(Intent(this@homeScreen, Notifications::class.java))
        }
    }
}