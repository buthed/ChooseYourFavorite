package com.example.chooseyoufavorite.data.room.categories

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface CategoriesDao{

    @Query("SELECT * FROM categories")
    fun readAllData(): LiveData<List<CategoriesEntity>>

//    @Query("SELECT * FROM CategoriesEntity WHERE categories_type=:categoryName")
//    fun selectMoviesCategories(categoryName: String): List<CategoriesEntity>
}