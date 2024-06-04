package uz.aiml.eslatma.educationcentre.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "kategoriya")
data class Category
    (
    @ColumnInfo(name = "kategoriya_nomi")
    val categoryName: String,
    @PrimaryKey(autoGenerate = true)
    val catId: Long = UNDIFINED_ID
) :Serializable{
    companion object {
        const val UNDIFINED_ID = 0L
    }
}