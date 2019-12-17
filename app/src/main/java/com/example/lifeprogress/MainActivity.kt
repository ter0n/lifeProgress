package com.example.lifeprogress

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskList = listOf("task1", "task2", "task3", "task4", "task5")

        val lvTaskAdapter = LVTasksAdapter(this, taskList)

        lv_tasks.adapter = lvTaskAdapter

//        lv_tasks.setOnItemClickListener { parent, view, position, id ->
//            Toast.makeText(this, taskList[position], Toast.LENGTH_SHORT).show()
//        }
    }
}
