package com.example.chooseyoufavorite.repository


import androidx.lifecycle.LiveData
import com.example.chooseyoufavorite.data.room.categories.CategoriesTypeDao
import com.example.chooseyoufavorite.data.room.categories.CategoriesTypeEntity

class CategoryTypeRepository(private val categoriesTypeDao: CategoriesTypeDao)  {

    val readDataCategoriesType: LiveData<List<CategoriesTypeEntity>> = categoriesTypeDao.readDataCategoriesTypes()
}