package reflect_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface my_mood_dao{
    @Insert
    fun updateMood(myMoodDao: my_moods)
    @Query("SELECT * FROM mood_table")
    fun getMoods(): Flow<List<my_moods>>
    @Transaction
    @Query("Select * from mood_table where mood_name= :mood_name")
    fun getMoodsWithEntries(mood_name: String): List<fullEntry>
    @Insert
    suspend fun insertEntry (entry:my_entry)


}