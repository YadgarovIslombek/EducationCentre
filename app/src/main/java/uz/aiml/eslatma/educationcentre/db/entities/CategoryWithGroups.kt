package uz.aiml.eslatma.educationcentre.db.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class CategoryWithGroups (
    @Embedded
    val category: Category,
    @Relation(
        parentColumn = "catId",
        entity = Group::class,
        entityColumn = "groupId",
        associateBy = Junction(
            value = CategoryAndGroups::class,
            parentColumn = "catId",
            entityColumn = "groupId"
        )
    )
    val group: List<Group>
){

}