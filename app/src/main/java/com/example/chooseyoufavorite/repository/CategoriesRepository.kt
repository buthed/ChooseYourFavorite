package com.example.chooseyoufavorite.repository

import com.example.chooseyoufavorite.model.room.categories.top250Movies.Top250MoviesDao

interface CategoriesRepository {
    fun getTop250Movies(): List<Top250MoviesDao>
}