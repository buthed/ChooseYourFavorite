package com.example.chooseyoufavorite.Models

sealed class AppState {
    data class Success(val categoryData: List<CategoryList>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}