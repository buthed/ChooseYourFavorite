package com.example.chooseyoufavorite.repository


import com.example.chooseyoufavorite.data.room.categories.CategoriesEntity

interface CategoryRepository  {

    fun getAllCategoriesByType(categoryName: String): List<CategoriesEntity>
}