package reflect_database

import android.app.Activity
import android.text.Selection
import androidx.recyclerview.widget.SortedList
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.sql.Time
import kotlin.time.measureTime

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
        fun hi(my_entry: my_entry) {
            val sortedSetOf = sortedSetOf(Int)
        }
}

