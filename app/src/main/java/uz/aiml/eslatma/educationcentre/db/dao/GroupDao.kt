package uz.aiml.eslatma.educationcentre.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import uz.aiml.eslatma.educationcentre.db.entities.Group
import uz.aiml.eslatma.educationcentre.db.entities.CategoryWithGroups

@Dao
interface GroupDao {

    @Insert
    fun add(group: Group):Long

    @Query("select * from gruppalar")
    fun getAllGroup():MutableList<Group>

    @Transaction
    @Query("select * from kategoriya")
    fun getGroupByCategoryId():MutableList<CategoryWithGroups>


}