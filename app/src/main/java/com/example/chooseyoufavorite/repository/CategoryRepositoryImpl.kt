package com.example.chooseyoufavorite.repository


import com.example.chooseyoufavorite.data.room.CategoriesDatabase
import com.example.chooseyoufavorite.data.room.categories.CategoriesDao
import com.example.chooseyoufavorite.data.room.categories.CategoriesEntity

class CategoryRepositoryImpl(private val categoriesDatabase: CategoriesDatabase) : CategoryRepository  {


    override fun getAllCategoriesByType(categoryName: String): List<CategoriesEntity> {
        return categoriesDatabase.categoriesDao().readAllData(categoryName)
    }
}