package reflect_database

import androidx.room.Embedded
import androidx.room.Relation

data class fullEntry(
//1 to N relationship
    @Embedded val mood: my_moods,

    @Relation(
        parentColumn = "mood_name",
        entityColumn = "mood_name"
    )
    val entry: List<my_entry>

)
