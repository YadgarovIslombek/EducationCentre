package uz.aiml.eslatma.educationcentre.db.entities

import androidx.room.Entity

@Entity(primaryKeys = ["catId", "groupId"])
data class CategoryAndGroups(
    val catId: Long,
    val groupId: Long,
) {
}