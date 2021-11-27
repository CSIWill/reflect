package reflect_database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mood_table")
data class my_moods(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "mood") val mood: String,
    @ColumnInfo(name = "hue") val hue: Int,
    @ColumnInfo(name = "saturation") val saturation: Float,
    @ColumnInfo(name = "lightness") val lightness: Float
)
