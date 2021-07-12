package com.example.chooseyoufavorite.Models.Repository

import com.example.chooseyoufavorite.Models.CategoryList
import com.example.chooseyoufavorite.Models.getCategoryListMovie
import com.example.chooseyoufavorite.Models.getCategoryListMusic

class RepositoryImpl : Repository {
    override fun getCategoryFromServer(movie_id: Int): CategoryList {
        TODO("Not yet implemented")
    }

    override fun getCategoryFromLocalStorageMovie() = getCategoryListMovie()
    override fun getCategoryFromLocalStorageMusic() = getCategoryListMusic()

}