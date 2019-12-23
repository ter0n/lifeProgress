package com.example.lifeprogress

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskList = listOf(
            DailyTask("task1", true),
            DailyTask("task2", false),
            DailyTask("task3", true),
            DailyTask("task4", true),
            DailyTask("task5", false)
        )

        val lvTaskAdapter = LVTasksAdapter(this, taskList)

        lv_tasks.adapter = lvTaskAdapter

    }
}
