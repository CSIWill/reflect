package reflect_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.*;

//exportSchema set to false as we only want 1 version of it for in-memory only case
@Database(entities = [my_entry::class], version = 1, exportSchema = false)
//create
abstract class my_database: RoomDatabase() {
    abstract fun reflect_dao(): my_dao
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
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}