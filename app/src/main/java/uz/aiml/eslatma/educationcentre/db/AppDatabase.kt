package uz.aiml.eslatma.educationcentre.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.aiml.eslatma.educationcentre.db.dao.CategoryAndGroupDao
import uz.aiml.eslatma.educationcentre.db.dao.CategoryDao
import uz.aiml.eslatma.educationcentre.db.dao.GroupDao
import uz.aiml.eslatma.educationcentre.db.dao.StudentDao
import uz.aiml.eslatma.educationcentre.db.entities.Category
import uz.aiml.eslatma.educationcentre.db.entities.CategoryAndGroups
import uz.aiml.eslatma.educationcentre.db.entities.Group
import uz.aiml.eslatma.educationcentre.db.entities.Student

@Database(entities = [Category::class, Group::class, Student::class,CategoryAndGroups::class], version = 1)
abstract class AppDatabase() : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
    abstract fun groupDao(): GroupDao
    abstract fun studentDao(): StudentDao
    abstract fun categoryAndGroupDaO(): CategoryAndGroupDao

    companion object {
        var db: AppDatabase? = null
        val dbName: String = "main"

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (db == null) {
                return Room.databaseBuilder(context, AppDatabase::class.java, dbName)
                    .allowMainThreadQueries().build()
            }
            return db!!
        }
    }
}