package com.example.reflect

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_mood.*

var moodString = ""

class Mood : AppCompatActivity() {
//class Mood : AppCompatActivity(), AdapterView.OnItemSelectedListener {
//class Mood : Activity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood)


        val mood_spinner: Spinner = findViewById(R.id.spinner1)
        // Create an ArrayAdapter
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.mood_list, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinner1.adapter = adapter


//        fun getValues(view: View) {
//            Toast.makeText(this, "Spinner 2 " + spinner1.selectedItem.toString(),
//                Toast.LENGTH_LONG).show()
//
//        }

        val mButton = findViewById<Button>(R.id.enterMoodBtn) as Button
        mButton.setOnClickListener{
            startActivity(Intent(this@Mood, MainActivity::class.java))
            Toast.makeText(this, "Mood " + spinner1.selectedItem.toString(),
                Toast.LENGTH_LONG).show()
            moodString = spinner1.selectedItem.toString()

        }
//        fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
//            // An item was selected. You can retrieve the selected item using
//            // parent.getItemAtPosition(pos)
//        }
//
//        fun onNothingSelected(parent: AdapterView<*>) {
//            // Another interface callback
//        }
//
//        spinner.onItemSelectedListener = this
//        Toast.makeText(this, "Spinner " + spinner1.selectedItem.toString(),
//            Toast.LENGTH_LONG).show()

//    val spinner= findViewById(R.id.spinner1)
//        mood_spinner.onItemSelectedListener = AdapterView.OnItemSelectedListener { parent, view, position, id ->
//            Toast.makeText(this, "You've got an event", Toast.LENGTH_SHORT).show()
//        }
    }
}