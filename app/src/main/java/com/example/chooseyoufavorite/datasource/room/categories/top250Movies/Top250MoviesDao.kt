package com.example.chooseyoufavorite.datasource.room.categories.top250Movies

import androidx.room.Dao
import androidx.room.Query

@Dao
interface Top250MoviesDao {

    @Query("SELECT * FROM Top250MoviesEntity")
    fun selectAll(): List<Top250MoviesEntity>
}