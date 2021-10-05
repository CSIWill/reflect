package reflect_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface reflect_dao {
//    Add Entry
    @Insert
    suspend fun addEntry(my_entry: reflect_entry)
//    List Entries
    @Query("SELECT * FROM journal_table")
    fun getEntries(): Flow<List<reflect_entry>>
}