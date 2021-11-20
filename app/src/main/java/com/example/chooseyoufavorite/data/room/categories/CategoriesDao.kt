package com.example.chooseyoufavorite.data.room.categories

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface CategoriesDao{


    @Query("SELECT * FROM categories")
    fun readAllData(): LiveData<List<CategoriesEntity>>

//    @Query("SELECT * FROM categories WHERE categories_type=:categoryName")
//    fun readAllData(categoryName: String): LiveData<List<CategoriesEntity>>


//    @Query("SELECT * FROM categories WHERE categories_type=:categoryName")
//    fun selectCategoriesByKey(categoryName: String): List<CategoriesEntity>
}