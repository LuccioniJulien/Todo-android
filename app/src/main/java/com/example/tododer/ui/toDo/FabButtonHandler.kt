package com.example.tododer.ui.toDo

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FabButtonHandler(private val fabAddToDo: FloatingActionButton) :
    RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        // scroll down
        if (dy > 0 && fabAddToDo.isShown) {
            fabAddToDo.hide()
        }
        // scroll up
        if (dy < 0 && !fabAddToDo.isShown) {
            fabAddToDo.show()
        }
    }
}