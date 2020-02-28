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

class RvAdapterToDo(private var todos: MutableList<Todo>, private val update: (Todo) -> Unit) :
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

    fun setNewTodos(newTodos: List<Todo>) {
        val new = (newTodos + todos).groupBy { it.id }
            .filter { it.value.size == 1 }
            .flatMap { it.value }
        if (new.count() == 1) {
            todos.add(0, new[0])
            notifyItemChanged(0)
        } else {
            todos = new.toMutableList()
            notifyItemRangeChanged(0, todos.size - 1)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var todoRow = view

        fun bind(todo: Todo, update: (Todo) -> Unit) {
            todoRow.tvwTitle.text = todo.title
            todoRow.tvwMessage.text = todo.resume
            todoRow.cbxIsDone.isChecked = todo.isDone

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

