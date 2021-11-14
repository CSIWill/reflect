package com.example.reflect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class reviewScreen : AppCompatActivity() {
    class reviewScreen : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.review_entry)

            // get reference to buttons
            //these are the buttons on review_entry
            val btnPrev = findViewById<Button>(R.id.previousEntry)
            val btnNext = findViewById<Button>(R.id.nextEntry)
            val entryDate = findViewById<TextView>(R.id.entryDate)
            val entryText = findViewById<TextView>(R.id.entryText)

            //this is the button on activity_main

            // set on-click listener
            btnPrev.setOnClickListener {
                entryText.setText(R.string.entryText1)
                entryDate.setText(R.string.entryDate1)
            }

            btnNext.setOnClickListener {
                entryText.setText(R.string.entryText2)
                entryDate.setText(R.string.entryDate2)
            }
        }
    }
}