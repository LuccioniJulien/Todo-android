package com.example.tododer.ui.addTodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.tododer.R
import com.example.tododer.model.Todo
import com.example.tododer.ui.toDo.ToDoViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_add_to_do.*

class AddToDoFragment : DialogFragment() {

    private val _todosViewModel: ToDoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_to_do, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnAdd.setOnClickListener { createTodo(it) }
        btnAdd.text = _todosViewModel.message
    }

    private fun createTodo(view: View) {
        val todo = Todo(txtTitle.text?.trim().toString(), txtResume.text?.trim().toString())
        _todosViewModel.addTodo(todo)
        Toast.makeText(context, "Todo added", Toast.LENGTH_LONG).show()
        NavHostFragment.findNavController(this).navigateUp()
    }
}
