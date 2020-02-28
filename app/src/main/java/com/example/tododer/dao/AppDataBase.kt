package com.example.tododer.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tododer.model.Todo

@Database(entities = arrayOf(Todo::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): ToDoDao
}

class Repository{
    companion object {
        private var repo:AppDatabase? = null
        fun getRepo(context:Context):AppDatabase? {
               if(repo == null) {
                   repo = Room.databaseBuilder(
                       context,
                       AppDatabase::class.java, "TodoDerBase"
                   ).build()
               }
            return repo
        }
    }
}