package com.example.chooseyoufavorite.data.room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.chooseyoufavorite.data.room.categories_fragments.CategoriesDao
import com.example.chooseyoufavorite.data.room.categories_fragments.CategoriesEntity
import com.example.chooseyoufavorite.data.room.categories_fragments.CategoriesTypeDao
import com.example.chooseyoufavorite.data.room.categories_fragments.CategoriesTypeEntity

@Database(entities = arrayOf(
    CategoriesEntity::class,
    CategoriesTypeEntity::class,
    ),version = 1)
abstract class CategoriesDatabase: RoomDatabase() {

    abstract fun categoriesDao(): CategoriesDao
    abstract fun categoriesTypeDao(): CategoriesTypeDao

}