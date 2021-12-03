package com.example.reflect

import kotlinx.coroutines.launch
import reflect_database.my_entry
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.asLiveData
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.runBlocking

class EntryViewModel(private val repository: EntryRepository) : ViewModel() {

//    fun addEntry(new_entry: my_entry) = runBlocking { repository.addEntry(new_entry) }
//    val allEntries = repository.entries.asLiveData()
    val allEntries: LiveData<List<my_entry>> = repository.entries.asLiveData()
    fun addEntry(new_entry: my_entry) = viewModelScope.launch {
        repository.addEntry(new_entry)
    }
}
