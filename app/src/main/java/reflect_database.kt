import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(journal_entry::class), version = 1)
abstract class reflect_database : RoomDatabase() {
    abstract
}
