package uz.aiml.eslatma.educationcentre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import uz.aiml.eslatma.educationcentre.adapters.CategoryAdapter
import uz.aiml.eslatma.educationcentre.databinding.ActivityMainBinding
import uz.aiml.eslatma.educationcentre.databinding.ItemAddCategoryBinding
import uz.aiml.eslatma.educationcentre.db.AppDatabase
import uz.aiml.eslatma.educationcentre.db.entities.Category

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var adapter: CategoryAdapter
    private val db: AppDatabase by lazy {
        AppDatabase.getInstance(this)
    }
    private lateinit var list: MutableList<Category>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var listSize = db.groupDao().getAllGroup().size
        list = db.categoryDao().getAllCategory()
        adapter = CategoryAdapter(list, { cat, pos -> }, { cat, pos -> }, { position ->
            run {
                val templist = db.categoryDao().getAllCategory()
                val category = templist[position]
                val intent = Intent(this@MainActivity, GroupActivity::class.java)
                intent.putExtra("cat_id", category.catId)
                startActivity(intent)
            }
        }, listSize ?: 0)
        binding.apply {
            rec.adapter = adapter
            fab.setOnClickListener {
                val alert = AlertDialog.Builder(this@MainActivity).create()
                val itemAddCategory = ItemAddCategoryBinding.inflate(
                    LayoutInflater.from(this@MainActivity),
                    null,
                    false
                )
                alert.setView(itemAddCategory.root)

                itemAddCategory.save.setOnClickListener {
                    val catName = itemAddCategory.etCat.text.toString()
                    val category  = Category(catName)
                    db.categoryDao().add(category)
                    list.add(category)
                    adapter.notifyItemInserted(list.size)
                    alert.dismiss()
                }
                alert.setCancelable(true)
                alert.show()

            }
        }
    }
}