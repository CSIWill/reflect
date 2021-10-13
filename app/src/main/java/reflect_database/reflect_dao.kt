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

    //// orders by Id in ascending order
    @Query("SELECT Id, journal_entry, journal_time, journal_mood FROM journal_table ORDER BY ID ASC")
    fun orderById(){
    }

    //// orders by journal_time in ascending order
    @Query("SELECT Id, journal_entry, journal_time, journal_mood FROM journal_table ORDER BY journal_time ASC")
    fun orderByDate(){
    }

    @Query("SELECT EXISTS(SELECT journal_entry FROM journal_table WHERE journal_time = journal_time)")
    fun getTimeEntry() {

    }

    @Query("SELECT EXISTS(SELECT journal_entry FROM journal_table WHERE journal_mood = journal_mood)")
    fun getMoodEntry() {

    }
}