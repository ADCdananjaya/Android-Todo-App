package com.example.todo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class SharedVModel(application: Application): AndroidViewModel(application) {
    val todoList = MutableLiveData<MutableList<String>>()

    init {
        todoList.value = mutableListOf()
    }

    fun addString( todo: String) {
        var currentList = todoList.value ?: emptyList<String>()
        var newList = currentList.toMutableList().apply {
            add(todo)
        }
        todoList.postValue(newList)
    }

    fun getLength(): Int {
        return todoList.value?.size ?: 0
    }
}