package reflect_database

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow


class reflect_repository(private val reflect_dao: my_dao) {

//    fun addEntry(new_entry: my_entry) = reflect_dao.addEntry(new_entry)

 //   fun getEntries(): Flow<List<my_entry>> = reflect_dao.getEntries()

    val allEntries: Flow<List<my_entry>> = reflect_dao.getEntries()

    suspend fun addEntry(new_entry: my_entry) = reflect_dao.addEntry(new_entry)
}