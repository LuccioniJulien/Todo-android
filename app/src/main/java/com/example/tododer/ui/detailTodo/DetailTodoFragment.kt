package com.example.tododer.ui.detailTodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.tododer.DetailBinding
import com.example.tododer.R
import com.example.tododer.model.Todo
import com.example.tododer.ui.toDo.ToDoViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailTodoFragment : BottomSheetDialogFragment() {

    private val viewModel: DetailTodoViewModel by viewModels()
    private val _todosViewModel: ToDoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<DetailBinding>(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        )
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {
            val id = DetailTodoFragmentArgs.fromBundle(it).idTodo
            val todo = _todosViewModel.getTodoFromList(id)
            viewModel.todoLiveData.value = todo
            deleteButton.setOnClickListener { delete(todo as Todo) }
        }
    }

    private fun delete(todo: Todo) {
        _todosViewModel.delete(todo)
        Toast.makeText(context, "Todo deleted", Toast.LENGTH_LONG).show()
        NavHostFragment.findNavController(this).navigateUp()
    }

}
