package reflect_database

import android.text.Selection
import androidx.recyclerview.widget.SortedList
import androidx.room.Dao
import androidx.room.Index
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import java.sql.Time

@Dao
interface my_dao {
//    Add Entry
    @Insert
    suspend fun addEntry(my_entry: my_entry)
//    List Entries
    @Query("SELECT * FROM journal_table")
    fun getEntries(): Flow<List<my_entry>>

//    List entry from date in descending order
//    @Query("SELECT journal_time FROM journal_table ORDER BY 'DESC'")
//    fun getDate(): Flow<List<my_entry>>

    //sort entries by date
   @Query("SELECT journal_time FROM journal_table ORDER BY 'DESC'")
   fun <my_entry> SortedList():Int

}
