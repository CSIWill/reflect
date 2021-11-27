package reflect_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [my_moods::class]), version = 1))
abstract class my_mood_database: RoomDatabase() {
    abstract fun mood_dao(): my_mood_dao
    companion object {
        @Volatile
        private var INSTANCE: my_mood_database? = null
        fun getDatabase(context: Context): my_mood_database {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    my_mood_database::class.java,
                    "mood_database")
                    .createFromAsset("database/mood_database.db")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}