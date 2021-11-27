package com.example.chooseyoufavorite.data.room.categories.movies.top250Movies

import androidx.room.Dao
import androidx.room.Query

@Dao
interface Top250MoviesDao{

    @Query("SELECT * FROM top250Movies")
    fun readAllData(): List<Top250MoviesEntity>
}