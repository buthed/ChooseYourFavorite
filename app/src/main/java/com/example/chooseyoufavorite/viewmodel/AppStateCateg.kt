package com.example.chooseyoufavorite.viewmodel

import com.example.chooseyoufavorite.data.room.categories.CategoriesEntity
import com.example.chooseyoufavorite.data.room.categories.CategoriesTypeEntity

sealed class AppStateCateg {
    data class Success(val weatherData: List<CategoriesTypeEntity>) : AppStateCateg()
    data class Error(val error: Throwable) : AppStateCateg()
    object Loading : AppStateCateg()
}
