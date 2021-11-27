package com.example.chooseyoufavorite.repository

import com.example.chooseyoufavorite.data.room.categories.movies.top250Movies.Top250MoviesEntity


interface GameRepository {

    fun getTop250Movies() : List<Top250MoviesEntity>
}