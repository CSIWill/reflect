package com.example.reflect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.reflect.EntryAdapter.EntryViewHolder
import reflect_database.my_entry

//class EntryAdapter: ListAdapter<my_entry, EntryViewHolder> (Entry_COMPARATOR)
class EntryAdapter: ListAdapter<my_entry, EntryViewHolder> (Entry_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        return EntryViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.journal_time + " " + current.mood_name + "\n" + current.journal_entry )
    }

    class EntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val entryView: TextView = itemView.findViewById(R.id.view_entry)

        fun bind(text: String?) {
            entryView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): EntryViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.entry_item, parent, false)
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