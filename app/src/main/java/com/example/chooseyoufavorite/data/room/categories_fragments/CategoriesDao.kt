package com.example.chooseyoufavorite.data.room.categories_fragments

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CategoriesDao{

    @Query("SELECT * FROM categories WHERE categories_id=:categories_id")
    fun readAllData(categories_id: String): List<CategoriesEntity>
}