package com.example.reflect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import reflect_database.my_database
import androidx.lifecycle.observe


class ReviewScreen : AppCompatActivity() {
    val vm: EntryViewModel by viewModels { EntryViewModelFactory(initDb()) }

    private fun initDb(): EntryRepository {
        val db = my_database.getDatabase(this)
        return EntryRepository(db.reflect_dao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.review_entry)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = EntryAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // get reference to buttons
        //these are the buttons on review_entry
        val btnPrev = findViewById<Button>(R.id.previousEntry)
        val btnNext = findViewById<Button>(R.id.nextEntry)
        val entryDate = findViewById<TextView>(R.id.entryDate)
        val entryText = findViewById<TextView>(R.id.entryText)

        //this is the button on activity_main

//        val mostRecent = vm.allEntries
//        entryText.setText(mostRecent)

        // set on-click listener
        btnPrev.setOnClickListener {
            entryText.setText(R.string.entryText1)
            entryDate.setText(R.string.entryDate1)
        }

        btnNext.setOnClickListener {
            entryText.setText(R.string.entryText2)
            entryDate.setText(R.string.entryDate2)
        }
        vm.allEntries.observe(owner = this) { journal_entry ->
            journal_entry.let {
                adapter.submitList(
                    it)
            }
        }
    }
}
