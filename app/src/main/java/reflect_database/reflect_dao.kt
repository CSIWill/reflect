package reflect_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface my_dao {
//    Add Entry
    @Insert
    suspend fun addEntry(my_entry: my_entry)
//    List Entries
    @Query("SELECT * FROM journal_table")
    fun getEntries(): Flow<List<my_entry>>
//    List Entry From date
//    @Query("SELECT journal_time FROM journal_table")
}