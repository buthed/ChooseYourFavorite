package com.example.chooseyoufavorite.viewmodel

import com.example.chooseyoufavorite.data.room.categories.CategoriesTypeEntity

sealed class AppStateCateg {
    data class Success(val categoryData: List<CategoriesTypeEntity>) : AppStateCateg()
    data class Error(val error: Throwable) : AppStateCateg()
    object Loading : AppStateCateg()
}
