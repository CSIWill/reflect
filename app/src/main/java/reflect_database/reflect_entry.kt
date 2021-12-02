package reflect_database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date


@Entity(
    tableName = "journal_table",
    foreignKeys = [
        ForeignKey(entity = my_moods::class,
            parentColumns = ["mood_id"],
            childColumns = ["journal_mood"])
    ]
)
data class my_entry(
//    @PrimaryKey val journal_entry: String
    @PrimaryKey(autoGenerate = true) val journal_id: Int,
//    Time of entry
    @ColumnInfo(name = "journal_time") val journal_time: Long,
//    Entry
    @ColumnInfo(name = "journal_entry") val journal_entry: String,
//    Mood Score
    @ColumnInfo(name = "journal_mood") val journal_mood: Int
)