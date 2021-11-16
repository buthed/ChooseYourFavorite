package com.example.chooseyoufavorite.room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.chooseyoufavorite.room.categories.topHorrors.TopHorrorsDao
import com.example.chooseyoufavorite.room.categories.topHorrors.TopHorrorsEntity
import com.example.chooseyoufavorite.room.categories.top250Movies.Top250MoviesDao
import com.example.chooseyoufavorite.room.categories.top250Movies.Top250MoviesEntity

@Database(
    entities = [
        Top250MoviesEntity::class,
        TopHorrorsEntity::class
    ], version = 1, exportSchema = false)
abstract class CategoriesDatabase: RoomDatabase() {
    abstract fun top250MoviesDao(): Top250MoviesDao
    abstract fun topHorrorsDao(): TopHorrorsDao
}