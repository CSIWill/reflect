package com.example.reflect


import android.os.Bundle

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ReviewScreen : AppCompatActivity() {
    private val entryViewModel: EntryViewModel by viewModels {
        EntryViewModelFactory((application as ReflectApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.review_entry)

        val recyclerView = findViewById<RecyclerView>(R.id.main_listView)
        val adapter = EntryAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        entryViewModel.allEntries.observe(
            this, Observer {
                entries -> entries?.let{adapter.submitList(it)}
            }
        )
    }
    }

