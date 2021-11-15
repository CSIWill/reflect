package com.example.reflect

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import reflect_database.my_entry
import reflect_database.reflect_repository

class EntryViewModel(private val repository: reflect_repository) : ViewModel() {

    val allEntries: LiveData<List<my_entry>> = repository.allEntries.asLiveData()

    fun addEntry(new_entry: my_entry) = viewModelScope.launch {
        repository.addEntry(new_entry)
    }
}