package com.example.reflect

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import reflect_database.my_entry
//import reflect_database.reflect_repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.runBlocking

class EntryViewModel(private val repository: EntryRepository) : ViewModel() {

    fun addEntry(new_entry: my_entry) = runBlocking { repository.addEntry(new_entry) }
    val allEntries: LiveData<List<my_entry>> = repository.entries.asLiveData()
//    fun addEntry(new_entry: my_entry) = viewModelScope.launch {
//        repository.addEntry(new_entry)
//    }
}
//class EntryViewModelFactory(private val repository: EntryRepository) : ViewModelProvider.Factory {
//    override fun <T: ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(EntryViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return EntryViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}