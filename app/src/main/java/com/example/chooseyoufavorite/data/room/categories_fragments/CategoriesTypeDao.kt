package com.example.chooseyoufavorite.data.room.categories_fragments

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CategoriesTypeDao{

    @Query("SELECT * FROM categories_type")
    fun readDataCategoriesTypes(): List<CategoriesTypeEntity>
}