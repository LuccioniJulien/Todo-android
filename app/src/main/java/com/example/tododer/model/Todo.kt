package com.example.tododer.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat
import java.util.*

@Entity
data class Todo(
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "resume") var resume: String?,
    @ColumnInfo(name = "isDone") var isDone: Boolean = false,
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    @ColumnInfo(name = "date")
    var date: String = DateFormat.getDateTimeInstance().format(Date())
)