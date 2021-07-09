package com.example.chooseyoufavorite.Models.Repository

import com.example.chooseyoufavorite.Models.CategoryList

interface Repository {
    fun getCategoryFromServer(movie_id: Int): CategoryList
    fun getCategoryFromLocalStorage(): List<CategoryList>
}