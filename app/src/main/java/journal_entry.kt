import androidx.room.*
import java.util.*

//enable search function
@Fts3
@Fts4
@Entity(tableName = "journal")
data class journal_entry(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = 'date') val date: ?,
    @ColumnInfo(name = 'journal entry') val journal_entry: String?

)
