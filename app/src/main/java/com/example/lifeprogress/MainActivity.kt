package com.example.lifeprogress

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var taskList : MutableList<DailyTask> = mutableListOf<DailyTask>()
    private lateinit var lvTaskAdapter : LVTasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val taskList = listOf(
//            DailyTask("task1", true),
//            DailyTask("task2", false),
//            DailyTask("ta sk3", true),
//            DailyTask("task4", true),
//            DailyTask("task5", false)
//        )

        taskList.add(DailyTask("task1", true))
        taskList.add(DailyTask("task2", false))
        taskList.add(DailyTask("task3", true))
        taskList.add(DailyTask("task4", true))
        taskList.add(DailyTask("task5", false))

//        val lvTaskAdapter = LVTasksAdapter(this, taskList)
        lvTaskAdapter = LVTasksAdapter(this, taskList)
        lv_tasks.adapter = lvTaskAdapter
        taskList.add(DailyTask("task6", false))
        lvTaskAdapter.notifyDataSetChanged()

    }

    fun addLVItem (veiw: View){
        var addedTask = etNewTask.text.toString()
        taskList.add(DailyTask(addedTask, false))
        lvTaskAdapter.notifyDataSetChanged()
    }

    fun removeLVItem (veiw: View){

    }

}
