package uz.aiml.eslatma.educationcentre.db.dao

import androidx.room.Dao
import androidx.room.Insert
import uz.aiml.eslatma.educationcentre.db.entities.CategoryAndGroups
import uz.aiml.eslatma.educationcentre.db.entities.CategoryWithGroups

@Dao
interface CategoryAndGroupDao {

    @Insert
    fun add(categoryWithGroups: CategoryWithGroups)
}