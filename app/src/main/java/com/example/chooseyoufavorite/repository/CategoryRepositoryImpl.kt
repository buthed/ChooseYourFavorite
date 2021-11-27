package com.example.chooseyoufavorite.repository


import com.example.chooseyoufavorite.data.room.CategoriesDatabase
import com.example.chooseyoufavorite.data.room.categories_fragments.CategoriesEntity

class CategoryRepositoryImpl(private val categoriesDatabase: CategoriesDatabase) : CategoryRepository  {

    override fun getAllCategoriesByType(categories_id: String): List<CategoriesEntity> {
        return categoriesDatabase.categoriesDao().readAllData(categories_id)
    }
}