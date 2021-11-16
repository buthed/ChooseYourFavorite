package com.example.chooseyoufavorite.room.categories.top250Movies

import androidx.room.Query

interface Top250MoviesDao {

    @Query("SELECT * FROM Top250MoviesEntity")
    fun selectAll(): List<Top250MoviesEntity>
}