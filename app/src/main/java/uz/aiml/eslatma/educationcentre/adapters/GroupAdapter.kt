package uz.aiml.eslatma.educationcentre.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.aiml.eslatma.educationcentre.databinding.ItemGroupBinding
import uz.aiml.eslatma.educationcentre.db.entities.Category
import uz.aiml.eslatma.educationcentre.db.entities.Group

class GroupAdapter(
    val list: MutableList<Group>,
    val onEdit: (cat: Category, position: Int) -> Unit,
    val onDelete: (cat: Category, position: Int) -> Unit,
    val onClick: (id: Long) -> Unit,
    val studentSize: Int
) : RecyclerView.Adapter<GroupAdapter.VH>() {

    inner class VH(var itemGroupBinding: ItemGroupBinding) :
        RecyclerView.ViewHolder(itemGroupBinding.root) {
        fun getBind(grup: Group, position: Int,context:Context) {
            itemGroupBinding.groupName.text = grup.groupName
            itemView.setOnClickListener {
                onClick.invoke(position.toLong())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.getBind(list[position], position,holder.itemGroupBinding.root.context)
    }
}