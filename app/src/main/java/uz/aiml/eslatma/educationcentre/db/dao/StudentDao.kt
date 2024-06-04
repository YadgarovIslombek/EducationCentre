package uz.aiml.eslatma.educationcentre.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import uz.aiml.eslatma.educationcentre.db.entities.Student
import uz.aiml.eslatma.educationcentre.db.entities.StudentWithGroup

@Dao
interface StudentDao {

    @Insert
    fun add(student: Student)

    @Query("select * from student")
    fun getAllStudent():MutableList<Student>


}