package com.example.chooseyoufavorite.viewmodel

import com.example.chooseyoufavorite.data.room.categories.CategoriesEntity

sealed class AppStateCategByType {
    data class Success(val weatherData: List<CategoriesEntity>) : AppStateCategByType()
    data class Error(val error: Throwable) : AppStateCategByType()
    object Loading : AppStateCategByType()
}
