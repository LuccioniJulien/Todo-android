package com.example.tododer.dao

import androidx.room.*
import com.example.tododer.model.Todo


@Dao
interface ToDoDao {
    @Query("SELECT * FROM Todo ORDER by date DESC")
    suspend fun getAll(): List<Todo>

    @Query("SELECT * FROM Todo WHERE id = :uid")
    suspend fun loadOneByUid(uid: Int): Todo

    @Insert
    suspend fun insert(todo: Todo): Long

    @Update
    suspend fun update(todo: Todo)

    @Delete
    suspend fun delete(todo: Todo)
}
