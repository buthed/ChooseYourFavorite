package com.example.chooseyoufavorite.repository


import com.example.chooseyoufavorite.data.room.categories.CategoriesTypeEntity

interface CategoryTypeRepository  {

    fun getAllCategoriesTypes(): List<CategoriesTypeEntity>

}