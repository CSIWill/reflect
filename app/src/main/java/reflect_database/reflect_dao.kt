package reflect_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface my_dao {
//    Add Entry
    @Insert
    suspend fun addEntry(new_entry: my_entry)
//    List Entries
    @Query("SELECT * FROM journal_table")
    fun getEntries(): Flow<List<my_entry>>
//    @Transaction
//    @Query("SELECT * FROM mood_table WHERE mood_id IN (SELECT journal_mood FROM journal_table)")
//    fun getFullEntries(): Flow<List<>>
//    List Entry From date
//    @Query("SELECT journal_time FROM journal_table")

    //// orders by Id in ascending order
//    @Query("SELECT Id, journal_entry, journal_time, journal_mood FROM journal_table ORDER BY ID ASC")
//    fun orderById(){
//    }
//
//    //// orders by journal_time in ascending order
//    @Query("SELECT Id, journal_entry, journal_time, journal_mood FROM journal_table ORDER BY journal_time ASC")
//    fun orderByDate(){
//    }
//
//    @Query("SELECT EXISTS(SELECT journal_entry FROM journal_table WHERE journal_time = journal_time)")
//    fun getTimeEntry() {
//
//    }
//
//    @Query("SELECT EXISTS(SELECT journal_entry FROM journal_table WHERE journal_mood = journal_mood)")
//    fun getMoodEntry() {
//    }
}