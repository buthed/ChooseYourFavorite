package com.example.chooseyoufavorite.data.room.categories

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CategoriesDao{

    @Query("SELECT * FROM categories WHERE categories_type=:categoryName")
    fun readAllData(categoryName: String): List<CategoriesEntity>
}