package com.example.chooseyoufavorite.repository


import androidx.lifecycle.LiveData
import com.example.chooseyoufavorite.data.room.categories.CategoriesDao
import com.example.chooseyoufavorite.data.room.categories.CategoriesEntity

interface CategoryRepository  {

    fun getAllCategoriesByType(categoryName: String): List<CategoriesEntity>
}