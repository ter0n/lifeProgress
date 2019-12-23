package com.example.lifeprogress

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.lv_tasks_item.view.*

class LVTasksAdapter(context: Context, tasks: List<DailyTask>) : ArrayAdapter<DailyTask>(context, 0, tasks) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val taskVeiw = convertView ?: LayoutInflater.from(context).inflate(R.layout.lv_tasks_item, parent, false)
        val currentTask = getItem(position)
        taskVeiw.textViewDescription.text = currentTask?.description
        if(currentTask?.complete == true)
            taskVeiw.checkBoxComplete.setChecked(true)
        else
            taskVeiw.checkBoxComplete.setChecked(false)
        return taskVeiw
    }
}