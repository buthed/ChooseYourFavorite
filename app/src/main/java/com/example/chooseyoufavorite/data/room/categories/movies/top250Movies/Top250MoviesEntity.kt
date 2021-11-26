package com.example.chooseyoufavorite.data.room.categories.movies.top250Movies

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Top 250 Movies")
data class Top250MoviesEntity(@PrimaryKey(autoGenerate = true) val id:Int,
                              @ColumnInfo(name = "title") val title: String,
                              @ColumnInfo(name = "cinema id") val cinemaId: Int)
