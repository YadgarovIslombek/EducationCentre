package uz.aiml.eslatma.educationcentre.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "student"
)
data class Student
    (
    val name :String,
    val surname:String,
    val phone:String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = UNDIFINED_ID
) {
    companion object {
        const val UNDIFINED_ID = 0L
    }
}