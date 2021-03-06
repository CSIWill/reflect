package com.example.reflect

//import reflect_database.reflect_repository


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class EntryViewModelFactory(private val repository: EntryRepository) : ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EntryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EntryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}