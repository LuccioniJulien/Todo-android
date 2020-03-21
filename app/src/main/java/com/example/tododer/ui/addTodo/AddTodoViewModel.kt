package com.example.tododer.ui.addTodo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tododer.model.Todo

class AddTodoViewModel : ViewModel() {
    var title: MutableLiveData<String> = MutableLiveData<String>()
    var resume: MutableLiveData<String> = MutableLiveData<String>()
    var titleValidationMessage: MutableLiveData<String> = MutableLiveData<String>()

    fun getTodo(): Todo? {
        if (title.value?.trim().isNullOrEmpty()) {
            titleValidationMessage.value = "Todo should not have empty title";
            return null
        }
        return Todo(title.value, resume.value)
    }

}