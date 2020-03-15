package com.example.tododer.ui.detailTodo

import android.app.Application
import androidx.lifecycle.*
import com.example.tododer.dao.AppDatabase
import com.example.tododer.dao.Repository
import com.example.tododer.model.Todo
import kotlinx.coroutines.launch

class DetailTodoViewModel() : ViewModel() {
    var todoLiveData: MutableLiveData<Todo> = MutableLiveData<Todo>()
}
