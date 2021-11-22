package com.example.chooseyoufavorite.data.room


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chooseyoufavorite.data.room.categories.CategoriesDao
import com.example.chooseyoufavorite.data.room.categories.CategoriesEntity
import com.example.chooseyoufavorite.data.room.categories.CategoriesTypeDao
import com.example.chooseyoufavorite.data.room.categories.CategoriesTypeEntity

@Database(entities = arrayOf(
    CategoriesEntity::class,
    CategoriesTypeEntity::class,
    ),version = 1)
abstract class CategoriesDatabase: RoomDatabase() {

    abstract fun categoriesDao(): CategoriesDao
    abstract fun categoriesTypeDao(): CategoriesTypeDao
    
}