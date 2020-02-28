package com.example.tododer.ui.toDo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tododer.dao.AppDatabase
import com.example.tododer.dao.Repository
import com.example.tododer.model.Todo
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ToDoViewModel(app: Application) : AndroidViewModel(app) {

    private var _db: AppDatabase? = null

    var message = ""

    init {
        _db = Repository.getRepo(app)
    }

    private val _liveTodos: MutableLiveData<MutableList<Todo>> by lazy {
        MutableLiveData<MutableList<Todo>>().also {
            loadTodos()
        }
    }

    val todos: LiveData<MutableList<Todo>> = _liveTodos

    fun loadTodos() {
        viewModelScope.launch {
            val todos = _db?.todoDao()?.getAll()
            _liveTodos.value = todos?.toMutableList()
        }
    }

    fun getPosition(todo: Todo): Int = _liveTodos.value?.indexOf(todo) as Int

    fun addTodo(todo: Todo) {
        viewModelScope.launch {
            _db?.todoDao()?.insert(todo)
            _liveTodos.value?.add(todo)
            _liveTodos.value = _liveTodos.value
        }
    }

    fun update(todo: Todo) {
        viewModelScope.launch {
            _db?.todoDao()?.update(todo)
        }
    }
}
