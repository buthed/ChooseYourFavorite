package com.example.chooseyoufavorite.data.room.categories.movies.top250Movies

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "top250Movies")
data class Top250MoviesEntity(@PrimaryKey(autoGenerate = true) val id:Int,
                              val title: String,
                              val cinemaId: Int)
