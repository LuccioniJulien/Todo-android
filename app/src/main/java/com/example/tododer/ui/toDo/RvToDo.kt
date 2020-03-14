package com.example.tododer.ui.toDo

import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.tododer.R
import com.example.tododer.model.Todo
import kotlinx.android.synthetic.main.todo_item_layout.view.*

class RvAdapterToDo(
    private var todos: MutableList<Todo>,
    private val update: (Todo) -> Unit,
    private val seeDetail: (View, Long) -> Unit
) :
    RecyclerView.Adapter<RvAdapterToDo.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.todo_item_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = todos.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(todos[position], update)
    }

    private fun add(todo: Todo) {
        todos.add(0, todo)
        notifyItemRangeChanged(0, todos.size - 1)
    }

    private fun delete(newTodos: List<Todo>) {
        val index = todos.indexOfFirst { !todos.contains(it) }
        if (index != -1) {
            todos.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    private fun init(newTodos: List<Todo>) {
        todos = newTodos.toMutableList()
        notifyItemRangeChanged(0, todos.size - 1)
    }

    fun setNewTodos(newTodos: List<Todo>) {
        val newLength = newTodos.size
        val oldLength = todos.size

        when (oldLength - newLength) {
            -1 -> add(newTodos.last())
            1 -> delete(newTodos)
            else -> {
                init(newTodos)
            }
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var todoRow = view

        fun bind(todo: Todo, update: (Todo) -> Unit) {
            todoRow.tvwTitle.text = todo.title
            todoRow.tvwMessage.text = todo.resume
            todoRow.cbxIsDone.isChecked = todo.isDone

            todoRow.setOnClickListener { seeDetail(it, todo.id ?: 0) }

            handleStrikeWord(todo.isDone)

            todoRow.cbxIsDone.setOnClickListener { v ->
                val isChecked = (v as CheckBox).isChecked
                handleStrikeWord(isChecked)
                todo.isDone = isChecked
                update(todo)
                Log.i("checkedList", "Yo")
            }
        }

        private fun handleStrikeWord(isDone: Boolean) {
            if (isDone) {
                todoRow.tvwTitle.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                todoRow.tvwTitle.paintFlags = 0
            }
        }
    }
}

