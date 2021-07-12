package com.example.chooseyoufavorite.Models.Repository

import com.example.chooseyoufavorite.Models.CategoryList

interface Repository {
    fun getCategoryFromServer(movie_id: Int): CategoryList
    fun getCategoryFromLocalStorageMovie(): List<CategoryList>
    fun getCategoryFromLocalStorageMusic(): List<CategoryList>
}