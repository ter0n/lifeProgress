package com.example.lifeprogress

import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


private const val CM_DELETE_ID = 1 //номер кнопки "Удалить" в контекстном меню

class MainActivity : AppCompatActivity() {

    private var taskList : MutableList<DailyTask> = mutableListOf<DailyTask>()
    private lateinit var lvTaskAdapter : LVTasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskList.add(DailyTask("task1", true))
        taskList.add(DailyTask("task2", false))
        taskList.add(DailyTask("task3", true))
        taskList.add(DailyTask("task4", true))
        taskList.add(DailyTask("task5", false))

        lvTaskAdapter = LVTasksAdapter(this, taskList)
        lv_tasks.adapter = lvTaskAdapter
        registerForContextMenu(lv_tasks) //прикрепляем контекстное меню
    }

    fun addLVItem (veiw: View){
        var addedTask = etNewTask.text.toString()
        taskList.add(DailyTask(addedTask, false))
        lvTaskAdapter.notifyDataSetChanged()
    }

    override fun onCreateContextMenu(menu : ContextMenu, v : View, menuInfo : ContextMenuInfo){
        super.onCreateContextMenu(menu, v, menuInfo)
        menu.add(0, CM_DELETE_ID, 0, "Удалить")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if(item.itemId == CM_DELETE_ID){
            //получаем информацию о пункте списка
            val acmi  = item.menuInfo as AdapterContextMenuInfo
            taskList.removeAt(acmi.position)
            lvTaskAdapter.notifyDataSetChanged()
            return true
        }
        return super.onContextItemSelected(item)
    }

}
