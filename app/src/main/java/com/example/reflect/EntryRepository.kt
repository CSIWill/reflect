//package com.example.reflect
//
//import androidx.annotation.WorkerThread
//import reflect_database.my_dao
//import reflect_database.my_entry
//
//class EntryRepository(private val entryDao: my_dao) {
//
//    val entries Flow<List<my_entry>> = entryDao.getEntries()
//
//    @Suppress("RedundantSuspendModifier")
//    @WorkerThread
//    suspend fun addEntry(journal_entry: my_entry) {
//        entryDao.addEntry(journal_entry)
//    }
//}