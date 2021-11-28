package reflect_database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "journal_table")
data class my_entry(
//    @PrimaryKey val journal_entry: String
    @PrimaryKey(autoGenerate = true) val id: Int,
//    Time of entry
    @ColumnInfo(name = "journal_time") val journal_time: Calendar = Calendar.getInstance(),
//    Entry
    @ColumnInfo(name = "journal_entry") val journal_entry: String,
//    Mood Score
//    @ColumnInfo(name = "journal_mood") val journal_mood: Float
)
