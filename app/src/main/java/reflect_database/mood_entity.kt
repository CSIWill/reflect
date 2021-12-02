package reflect_database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mood_table")
data class my_moods(
    @PrimaryKey val mood_id: Int,
    @ColumnInfo(name = "mood_name") val mood_name: String,
    @ColumnInfo(name = "hue_val") val hue_val: Double,
    @ColumnInfo(name = "saturation_val") val saturation_val: Double,
    @ColumnInfo(name = "lightness_val") val lightness_val: Double
)
