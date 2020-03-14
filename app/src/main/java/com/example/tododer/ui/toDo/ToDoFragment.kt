package com.example.tododer.ui.toDo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tododer.R
import com.example.tododer.extension.hideKeyboard
import com.example.tododer.model.Todo
import kotlinx.android.synthetic.main.fragment_to_do.*

class ToDoFragment : Fragment() {

    private val _viewModel: ToDoViewModel by activityViewModels()
    private lateinit var _rcv: RvAdapterToDo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_to_do, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rcvTodos.layoutManager = LinearLayoutManager(context)
        _rcv = RvAdapterToDo(mutableListOf(), { update(it) }, { v, id -> navigateDetail(v, id) })
        rcvTodos.adapter = _rcv

        _viewModel.todos.observe(viewLifecycleOwner) {
            _rcv.setNewTodos(it)
        }
        hideKeyboard()
        fabAddToDo.setOnClickListener { navigateAddToDo(it) }
        rcvTodos.addOnScrollListener(FabButtonHandler(fabAddToDo))
    }

    private fun update(todo: Todo) {
        _viewModel.update(todo)
    }

    private fun navigateAddToDo(view: View) {
        view.findNavController().navigate(R.id.action_toDoFragment_to_addToDoFragment)
    }

    private fun navigateDetail(view: View, id: Long) {

        view.findNavController().navigate(R.id.action_toDoFragment_to_detailTodoFragment)
    }
}
