package com.example.tododer.ui.addTodo
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddTodoViewModel:ViewModel() {
    var title : MutableLiveData<String> = MutableLiveData<String>()
    var resume : MutableLiveData<String> = MutableLiveData<String>()
    var titleValidationMessage : MutableLiveData<String> = MutableLiveData<String>()

}