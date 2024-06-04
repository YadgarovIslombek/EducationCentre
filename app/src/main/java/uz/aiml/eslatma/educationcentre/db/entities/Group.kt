package uz.aiml.eslatma.educationcentre.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "gruppalar"
)
data class Group
    (
    @ColumnInfo(name = "group_nomi")
    val groupName: String,
    @PrimaryKey(autoGenerate = true)
    val groupId: Long = UNDIFINED_ID
) {
    companion object {
        const val UNDIFINED_ID = 0L
    }

}