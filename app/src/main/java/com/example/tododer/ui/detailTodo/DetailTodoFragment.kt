package com.example.tododer.ui.detailTodo

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.tododer.R
import com.example.tododer.ui.toDo.ToDoViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class DetailTodoFragment : BottomSheetDialogFragment() {

    private val viewModel: DetailTodoViewModel by viewModels()
    private val _todosViewModel: ToDoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        Toast.makeText(context, "Todo added", Toast.LENGTH_LONG).show()
    }

}
