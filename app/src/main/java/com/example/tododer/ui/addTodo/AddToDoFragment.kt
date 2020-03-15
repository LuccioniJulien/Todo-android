package com.example.tododer.ui.addTodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.tododer.AddTodoBinding
import com.example.tododer.R
import com.example.tododer.model.Todo
import com.example.tododer.ui.toDo.ToDoViewModel
import kotlinx.android.synthetic.main.fragment_add_to_do.*

class AddToDoFragment : DialogFragment() {

    private val viewModel: AddTodoViewModel by activityViewModels()
    private val _todosViewModel: ToDoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<AddTodoBinding>(
            inflater,
            R.layout.fragment_add_to_do,
            container,
            false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnAdd.setOnClickListener { createTodo(it) }
    }

    private fun createTodo(view: View) {
        val todo = Todo(txtTitle.text?.trim().toString(), txtResume.text?.trim().toString())
        _todosViewModel.addTodo(todo)
        Toast.makeText(context, "Todo added", Toast.LENGTH_LONG).show()
        NavHostFragment.findNavController(this).navigateUp()
    }
}
