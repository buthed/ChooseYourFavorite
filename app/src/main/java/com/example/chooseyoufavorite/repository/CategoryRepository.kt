package com.example.chooseyoufavorite.repository


import com.example.chooseyoufavorite.data.room.categories_fragments.CategoriesEntity

interface CategoryRepository  {

    fun getAllCategoriesByType(categoryName: String): List<CategoriesEntity>
}