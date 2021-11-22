package com.example.chooseyoufavorite.repository


import com.example.chooseyoufavorite.data.room.CategoriesDatabase
import com.example.chooseyoufavorite.data.room.categories.CategoriesTypeDao
import com.example.chooseyoufavorite.data.room.categories.CategoriesTypeEntity

class CategoryTypeRepositoryImpl(private val categoriesDatabase: CategoriesDatabase) : CategoryTypeRepository   {


    override fun getAllCategoriesTypes(): List<CategoriesTypeEntity> {
        return  categoriesDatabase.categoriesTypeDao().readDataCategoriesTypes()
    }
}