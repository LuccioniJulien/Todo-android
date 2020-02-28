package com.example.tododer.ui.addTodo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tododer.dao.AppDatabase
import com.example.tododer.dao.Repository
import com.example.tododer.model.Todo
import kotlinx.coroutines.launch

class AddToDoViewModel(app: Application) : AndroidViewModel(app) {
    private var _db: AppDatabase? = null

    init {
        _db = Repository.getRepo(app)
    }

    fun addTodo(todo: Todo) {

    }

}
