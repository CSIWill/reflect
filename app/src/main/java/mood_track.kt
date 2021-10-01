import android.graphics.Color
import androidx.room.*

//Enable search functionality
@Fts3
@Fts4
@Entity(tableName = "Mood Table")
data class mood_track(
//    Color value of Mood
    @PrimaryKey val id: Int,
//    Numerical mood score
    @ColumnInfo(name = 'mood_scale')val mood_scale: Color,
    @ColumnInfo(name = 'mood_score')val mood_score: Float?,
    @ColumnInfo(name = 'mood_selection')val mood_selection: Int?
)
