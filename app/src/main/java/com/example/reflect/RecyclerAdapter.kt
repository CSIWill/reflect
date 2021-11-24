package com.example.reflect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.R
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(com.example.reflect.R.layout.review_entry, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
      //  var itemDate: TextView
      //  var itemEntry: TextView
        //var itemMood: TextView

        init {
          //  itemDate = itemView.findViewById(com.example.reflect.R.id.entryDate)
          //  itemEntry = itemView.findViewById(com.example.reflect.R.id.listView)
            //itemMood = itemView.findViewById(com.example.reflect.R.id.item_mood)
        }
    }
}