package com.example.chooseyoufavorite.viewmodel

import com.example.chooseyoufavorite.data.room.categories.CategoriesEntity

sealed class AppStateCategByType {
    data class Success(val categoryDataByType: List<CategoriesEntity>) : AppStateCategByType()
    data class Error(val error: Throwable) : AppStateCategByType()
    object Loading : AppStateCategByType()
}
