package reflect_database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mood_table")
data class my_moods(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "mood") val mood: String,
    @ColumnInfo(name = "mood_score") val mood_score: Float
)
