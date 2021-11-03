package com.example.reflect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_mood.*


class Mood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood)

        val mButton = findViewById<Button>(R.id.enterMoodBtn) as Button
        mButton.setOnClickListener{
            startActivity(Intent(this@Mood, MainActivity::class.java))
        }

        // Create an ArrayAdapter
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.mood_list, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinner1.adapter = adapter


        fun getValues(view: View) {
            Toast.makeText(this, "Spinner 2 " + spinner1.selectedItem.toString(),
                Toast.LENGTH_LONG).show()

        }
    }
}