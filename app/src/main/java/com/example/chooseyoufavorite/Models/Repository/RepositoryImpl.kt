package com.example.chooseyoufavorite.Models.Repository

import com.example.chooseyoufavorite.Models.CategoryList
import com.example.chooseyoufavorite.Models.getCategoryList

class RepositoryImpl : Repository {
    override fun getCategoryFromServer(movie_id: Int): CategoryList {
        TODO("Not yet implemented")
    }

    override fun getCategoryFromLocalStorage() = getCategoryList()

}