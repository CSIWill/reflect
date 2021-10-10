package reflect_database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey


@Entity(tableName = "journal_table")
data class my_entry(
    @PrimaryKey val id: Int,
//    Time of entry
    @NonNull @ColumnInfo(name = "journal_time") val journal_time: Int,
//    Entry
    @NonNull @ColumnInfo(name = "journal_entry") val journal_entry: String,
//    Mood Score
    @NonNull @ColumnInfo(name = "journal_mood") val journal_mood: Float
)

