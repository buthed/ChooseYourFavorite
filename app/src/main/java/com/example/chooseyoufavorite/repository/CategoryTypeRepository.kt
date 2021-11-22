package com.example.chooseyoufavorite.repository


import androidx.lifecycle.LiveData
import com.example.chooseyoufavorite.data.room.categories.CategoriesTypeDao
import com.example.chooseyoufavorite.data.room.categories.CategoriesTypeEntity

interface CategoryTypeRepository  {

    fun getAllCategoriesTypes(): List<CategoriesTypeEntity>

}