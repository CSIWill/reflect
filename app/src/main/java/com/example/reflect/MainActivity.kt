package com.example.reflect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



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
            mAlertDialog.setIcon(R.mipmap.ic_launcher);

            mAlertDialog.setPositiveButton("Submit"){dialog, id->

                Toast.makeText(this@MainActivity, "Submitted :D", Toast.LENGTH_SHORT).show() //action After submitted


                val text = editText.text // TEXT - THIS NEEDS TO BE ADDED TO THE DATABASE

                Toast.makeText(this, text, Toast.LENGTH_LONG).show() // Shouts text - Can remove when database works
            }

            mAlertDialog.setNegativeButton("Go Back"){dialog, id->
                dialog.dismiss()

        }
        mAlertDialog.show()
        }


    }

}