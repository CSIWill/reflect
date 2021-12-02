package reflect_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface my_mood_dao{
    @Insert
    fun updateMood(myMoodDao: my_moods)
    @Query("SELECT * FROM mood_table")
    fun getEntries(): Flow<List<my_moods>>
}