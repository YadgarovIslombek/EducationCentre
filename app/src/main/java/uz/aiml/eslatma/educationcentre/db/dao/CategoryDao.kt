package uz.aiml.eslatma.educationcentre.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.aiml.eslatma.educationcentre.db.entities.Category

@Dao
interface CategoryDao {

    @Insert
    fun add(category: Category)

    @Query("select * from kategoriya")
    fun getAllCategory():MutableList<Category>

}