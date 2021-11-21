package com.example.chooseyoufavorite.repository


import androidx.lifecycle.LiveData
import com.example.chooseyoufavorite.data.room.categories.CategoriesDao
import com.example.chooseyoufavorite.data.room.categories.CategoriesEntity

class CategoryRepository(private val categoriesDao: CategoriesDao, categoryName: String)  {

    val readAllData: LiveData<List<CategoriesEntity>> = categoriesDao.readAllData(categoryName)
}