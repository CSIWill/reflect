package com.example.reflect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val showButton = findViewById<Button>(R.id.showInput)
       val editText = findViewById<EditText>(R.id.editText)

        showButton.setOnClickListener{

            val text = editText.text

            Toast.makeText(this, text, Toast.LENGTH_LONG).show()

        }





    }



}