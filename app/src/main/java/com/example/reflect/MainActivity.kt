package com.example.reflect

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.*
import reflect_database.my_database
import reflect_database.my_entry
import java.util.Date
import com.example.reflect.Mood
import kotlinx.android.synthetic.main.activity_mood.*

class MainActivity : AppCompatActivity() {

    private val entryViewModel: EntryViewModel by viewModels {
        EntryViewModelFactory((application as ReflectApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val showButton = findViewById<Button>(R.id.showInput)
        val editText = findViewById<EditText>(R.id.editText)

//ALERT BUTTON
        val mAlertDialogBtn = findViewById<Button>(R.id.showInput)

        showInput.setOnClickListener {
            val mAlertDialog = AlertDialog.Builder(this@MainActivity)
            mAlertDialog.setTitle("PLEASE REMEMBER") //alert dialog title
            mAlertDialog.setMessage("You Will Not Be Able To Edit Your Journal Entry After You Hit Submit")
            mAlertDialog.setIcon(R.mipmap.ic_launcher)

            mAlertDialog.setPositiveButton("Submit"){dialog, id->

                Toast.makeText(this@MainActivity, "Submitted :D", Toast.LENGTH_SHORT).show() //action After submitted


                val text = editText.text // TEXT - THIS NEEDS TO BE ADDED TO THE DATABASE

                val currentTime:Date = Date()

                val simpleDateFormat = SimpleDateFormat("MMMM/dd/yyyy kk:mm")
                val dateString = simpleDateFormat.format(currentTime.getTime())
                val mood_string = moodString

                entryViewModel.addEntry(my_entry(0,dateString,text.toString(),moodString))


                Toast.makeText(this, text, Toast.LENGTH_LONG).show() // Shouts text - Can remove when database works
                startActivity(Intent(this@MainActivity, homeScreen::class.java))
            }
            mAlertDialog.setNegativeButton("Go Back") { dialog, id ->
                dialog.dismiss()
            }
        mAlertDialog.show()
        }
    }
}