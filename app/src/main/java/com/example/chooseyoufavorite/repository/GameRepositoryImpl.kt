package com.example.chooseyoufavorite.repository

import com.example.chooseyoufavorite.data.room.CategoriesDatabase
import com.example.chooseyoufavorite.data.room.categories.movies.top250Movies.Top250MoviesEntity

class GameRepositoryImpl (private val categoriesDatabase: CategoriesDatabase) : GameRepository  {
    override fun getTop250Movies(): List<Top250MoviesEntity> {
        return categoriesDatabase.top250MoviesDao().readAllData()
    }
}
