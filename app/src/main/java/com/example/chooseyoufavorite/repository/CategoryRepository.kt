package com.example.chooseyoufavorite.repository


import com.example.chooseyoufavorite.data.room.categories_fragments.CategoriesEntity

interface CategoryRepository  { //TODO unite 2 repositories

    fun getAllCategoriesByType(categories_id: String): List<CategoriesEntity>
}