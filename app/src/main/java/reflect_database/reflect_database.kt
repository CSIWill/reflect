package reflect_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//exportSchema set to false as we only want 1 version of it for in-memory only case
@Database(entities = arrayOf(reflect_entry::class), version = 1, exportSchema = false)
//create
abstract class reflect_database: RoomDatabase() {
    abstract fun reflect_dao(): reflect_dao
    companion object {
        @Volatile
        private var INSTANCE: reflect_database? = null
        fun getDatabase(context: Context): reflect_database {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    reflect_database::class.java,
                    "reflect_database")
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
}