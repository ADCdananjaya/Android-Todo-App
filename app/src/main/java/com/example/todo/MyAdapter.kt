package com.example.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val sharedViewModel: SharedVModel): RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val todoLayout= layoutInflater.inflate(R.layout.todo_item, parent, false)

        return MyViewHolder(todoLayout)
    }

    override fun getItemCount(): Int {
        return sharedViewModel.getLength()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.textView.text = "Lucifer devon"
        val item = sharedViewModel.todoList.value?.get(position)
        holder.textView.text = item
    }
}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val textView = view.findViewById<TextView>(R.id.textView)
}