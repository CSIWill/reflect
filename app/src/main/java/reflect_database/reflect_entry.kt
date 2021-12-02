package reflect_database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date


@Entity(
    tableName = "journal_table",
//    foreignKeys = [
//        ForeignKey(entity = my_moods::class,
//            parentColumns = ["mood_name"],
//            childColumns = ["mood_name"])
//    ]
)
data class my_entry(
//    @PrimaryKey val journal_entry: String
    @PrimaryKey(autoGenerate = true) val journal_id: Int,
//    Time of entry
    @ColumnInfo(name = "journal_time") val journal_time: String,
//    Entry
    @ColumnInfo(name = "journal_entry") val journal_entry: String,
//    Mood Score
    @ColumnInfo(name = "mood_name") val mood_name: String
)