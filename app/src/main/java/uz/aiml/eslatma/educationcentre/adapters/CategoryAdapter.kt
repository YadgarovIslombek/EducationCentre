package uz.aiml.eslatma.educationcentre.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.aiml.eslatma.educationcentre.databinding.ItemCategoryBinding
import uz.aiml.eslatma.educationcentre.db.entities.Category
import java.util.Optional

class CategoryAdapter(
    val list: MutableList<Category>,
    val onEdit: (cat: Category, position: Int) -> Unit,
    val onDelete: (cat: Category, position: Int) -> Unit,
    val onClick: (id: Int) -> Unit,
    val groupSize: Int
) : RecyclerView.Adapter<CategoryAdapter.VH>() {

    inner class VH(var itemCategory: ItemCategoryBinding) :
        RecyclerView.ViewHolder(itemCategory.root) {
        fun getBind(cat: Category, position: Int) {
            itemCategory.catName.text = cat.categoryName
            itemCategory.catSize.text = groupSize.toString()

            itemView.setOnClickListener {
                onClick.invoke(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.getBind(list[position], position)
    }
}