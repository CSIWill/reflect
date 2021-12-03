package reflect_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import net.sqlcipher.database.*
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope

//exportSchema set to false as we only want 1 version of it for in-memory only case
@Database(entities = [my_entry::class, my_moods::class], version = 1, exportSchema = false)
//@TypeConverters(Converters::class)
//create
abstract class my_database: RoomDatabase() {
    abstract fun reflect_dao(): my_dao
    abstract fun mood_dao(): my_mood_dao
    companion object {
        @Volatile
        private var INSTANCE: my_database? = null
        fun getDatabase(context: Context): my_database {
            return INSTANCE ?: synchronized(this) {
                val passphrase = SQLiteDatabase.getBytes("Passphras3".toCharArray())
                val factory = SupportFactory(passphrase)
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    my_database::class.java,
                    "reflect_database")

                    .openHelperFactory(factory)
//                    .fallbackToDestructiveMigration()

                    .addCallback(object:Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            ioThread {
                                getDatabase(context).mood_dao().updateMood(my_moods("Grouchy",0.0,100.0,50.0))
                                getDatabase(context).mood_dao().updateMood(my_moods("Nervous",39.0,100.0,50.0))
                                getDatabase(context).mood_dao().updateMood(my_moods("Happy",60.0,100.0,50.0))
                                getDatabase(context).mood_dao().updateMood(my_moods("Calm",120.0,100.0,50.0))
                                getDatabase(context).mood_dao().updateMood(my_moods("Sad",240.0,100.0,50.0))
                                getDatabase(context).mood_dao().updateMood(my_moods("Distant",275.0,100.0,50.0))
                                getDatabase(context).mood_dao().updateMood(my_moods("Loving",300.0,100.0,50.0))
                            }
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }
//        private class reflectDatabaseCallback(
//            private val scope: CoroutineScope
//        ) : RoomDatabase.Callback() {
//            override fun onCreate(db:SupportSQLiteDatabase) {
//                super.onCreate(db)
//            }
//        }
//        suspend fun moodDatabase(mood_dao: my_mood_dao) {
//            mood_dao.updateMood(my_moods(1,"Grouchy",0.0,100.0,50.0))
//            mood_dao.updateMood(my_moods(2,"Nervous",39.0,100.0,50.0))
//            mood_dao.updateMood(my_moods(3,"Happy",60.0,100.0,50.0))
//            mood_dao.updateMood(my_moods(4,"Calm",120.0,100.0,50.0))
//            mood_dao.updateMood(my_moods(5,"Sad",240.0,100.0,50.0))
//            mood_dao.updateMood(my_moods(6,"Distant",275.0,100.0,50.0))
//            mood_dao.updateMood(my_moods(7,"Loving",300.0,100.0,50.0))
//        }
    }
}