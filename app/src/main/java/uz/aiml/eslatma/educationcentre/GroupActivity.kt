package uz.aiml.eslatma.educationcentre

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import uz.aiml.eslatma.educationcentre.adapters.GroupAdapter
import uz.aiml.eslatma.educationcentre.databinding.ActivityGroupBinding
import uz.aiml.eslatma.educationcentre.databinding.ItemAddGroupBinding
import uz.aiml.eslatma.educationcentre.db.AppDatabase
import uz.aiml.eslatma.educationcentre.db.entities.Category
import uz.aiml.eslatma.educationcentre.db.entities.CategoryAndGroups
import uz.aiml.eslatma.educationcentre.db.entities.CategoryWithGroups
import uz.aiml.eslatma.educationcentre.db.entities.Group

class GroupActivity : AppCompatActivity() {
    private val binding: ActivityGroupBinding by lazy {
        ActivityGroupBinding.inflate(layoutInflater)
    }
    private lateinit var list: MutableList<Group>

    private val db: AppDatabase by lazy {
        AppDatabase.getInstance(this)
    }
    private lateinit var adapter: GroupAdapter
    var id = 0L;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        id = intent.getLongExtra("cat_id", 0L)

        var listSize = db.studentDao().getAllStudent().size
        db.groupDao().getGroupByCategoryId().map {
            list = it.group.toMutableList()
        }
        adapter = GroupAdapter(list, { cat, pos -> }, { cat, pos -> }, { id -> }, listSize)
        binding.apply {
            rec.adapter = adapter
            fab.setOnClickListener {

                val alert = AlertDialog.Builder(this@GroupActivity).create()
                val itemAddGroupBinding = ItemAddGroupBinding.inflate(
                    LayoutInflater.from(this@GroupActivity),
                    null,
                    false
                )
                alert.setView(itemAddGroupBinding.root)

                itemAddGroupBinding.save.setOnClickListener {
                    var groupName = itemAddGroupBinding.etGroup.text.toString()
                    val group  = Group(groupName = groupName)
                    val groupId = db.groupDao().add(group)
                    db.categoryAndGroupDaO().add(CategoryWithGroups())
                    list.add(group)
                    adapter.notifyItemInserted(list.size)
                    alert.dismiss()
                }
                alert.setCancelable(true)
                alert.show()

            }
        }
    }
}