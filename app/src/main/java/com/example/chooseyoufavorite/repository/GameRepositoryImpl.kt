package com.example.chooseyoufavorite.repository

import androidx.room.Dao
import com.example.chooseyoufavorite.data.room.CategoriesDatabase
import com.example.chooseyoufavorite.data.room.categories.movies.top250Movies.Top250MoviesEntity

class GameRepositoryImpl (private val categoriesDatabase: CategoriesDatabase) : GameRepository  {

    override fun getTop250Movies(categoryName: String): List<Top250MoviesEntity> {
        return categoriesDatabase.Top250MoviesDao().readAllData(categoryName)
    }
}