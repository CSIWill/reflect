package com.example.reflect

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reflect.EntryRepository
import com.example.reflect.EntryViewModel
import com.example.reflect.EntryViewModelFactory
import com.example.reflect.R
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.review_entry.*
import reflect_database.my_database
import reflect_database.my_entry

class ReviewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.review_entry)

        val recyclerView = findViewById<ListView>(R.id.main_listView)
        val adapter = EntryAdapter()
        //recyclerView.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)



//        val entry = arrayOf("Test1", "Test2", "test3")
//
//        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
//            this, android.R.layout.simple_list_item_1, entry
//        )
//
//        listView.adapter= arrayAdapter
//
//        listView.setOnItemClickListener { adapterView, view, i, l ->
//            Toast.makeText(this, "Testing lmao " + entry[i],Toast.LENGTH_LONG)
//                .show()
//        }


        }
    }

