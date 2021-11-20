package com.example.chooseyoufavorite.data.room.categories

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface CategoriesTypeDao{

    @Query("SELECT * FROM categories_type")
    fun readDataCategoriesTypes(): LiveData<List<CategoriesTypeEntity>>

//    @Query("SELECT * FROM CategoriesEntity WHERE categories_type=:categoryName")
//    fun selectMoviesCategories(categoryName: String): List<CategoriesEntity>
}