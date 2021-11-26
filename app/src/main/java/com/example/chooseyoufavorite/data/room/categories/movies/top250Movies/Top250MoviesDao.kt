package com.example.chooseyoufavorite.data.room.categories.movies.top250Movies

import androidx.room.Dao
import androidx.room.Query

@Dao
interface Top250MoviesDao{

    @Query("SELECT `cinema id` FROM `Top 250 movies`")
    fun readAllData(categoryName: String): List<Top250MoviesEntity>
}