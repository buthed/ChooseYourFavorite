package com.example.chooseyoufavorite.viewmodel

import com.example.chooseyoufavorite.data.room.categories.movies.top250Movies.Top250MoviesEntity

sealed class AppStateCategGame {
    data class Success(val cardsGame: List<Top250MoviesEntity>) : AppStateCategGame()
    data class Error(val error: Throwable) : AppStateCategGame()
    object Loading : AppStateCategGame()
}
