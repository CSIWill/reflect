package com.example.reflect

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import reflect_database.my_dao
import reflect_database.my_entry

class EntryRepository(private val entryDao: my_dao) {

    val entries: Flow<List<my_entry>> = entryDao.getEntries()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun addEntry(my_journal_entry: my_entry) {
        entryDao.addEntry(my_journal_entry)
    }
}
//class EntryRepository(private val reflect_dao: my_dao) {
//    suspend fun addEntry(new_entry: my_entry) = reflect_dao.addEntry(new_entry)
//
//    val allEntries: Flow<List<my_entry>> = reflect_dao.getEntries()
//
//}