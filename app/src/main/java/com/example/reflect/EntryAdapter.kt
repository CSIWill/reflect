package com.example.reflect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import reflect_database.my_dao
import reflect_database.my_entry

//private val entries: List<my_dao>

class EntryAdapter: ListAdapter<my_entry, EntryAdapter.EntryViewHolder> (Entry_COMPARATOR){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        return EntryViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
//        val current = getItem(position)
//        holder.bind(current.word)
    }

    class EntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val entryItemView: TextView = itemView.findViewById(R.id.listView)

        fun bind(text: String?) {
            entryItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): EntryViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.review_entry, parent, false)
                return EntryViewHolder(view)
            }
        }
    }

    companion object {
        private val Entry_COMPARATOR = object : DiffUtil.ItemCallback<my_entry>() {
            override fun areItemsTheSame(oldItem: my_entry, newItem: my_entry): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: my_entry, newItem: my_entry): Boolean {
                return oldItem.journal_entry == newItem.journal_entry
            }
        }
    }
}