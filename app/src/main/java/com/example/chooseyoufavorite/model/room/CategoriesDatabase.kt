package com.example.chooseyoufavorite.model.room


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chooseyoufavorite.model.room.categories.topHorrors.TopHorrorsDao
import com.example.chooseyoufavorite.model.room.categories.topHorrors.TopHorrorsEntity
import com.example.chooseyoufavorite.model.room.categories.top250Movies.Top250MoviesDao
import com.example.chooseyoufavorite.model.room.categories.top250Movies.Top250MoviesEntity

@Database(
    entities = [
        Top250MoviesEntity::class,
        TopHorrorsEntity::class
    ], version = 1, exportSchema = false)
abstract class CategoriesDatabase: RoomDatabase() {

    abstract fun top250MoviesDao(): Top250MoviesDao
    abstract fun topHorrorsDao(): TopHorrorsDao

    companion object {
        @Volatile
        private var appInstance: CategoriesDatabase? = null
        private var nameDB = "CategoriesDB"

        fun getDatabase(context: Context): CategoriesDatabase{
            val tempInstance = appInstance
            if (tempInstance!= null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CategoriesDatabase::class.java,
                    nameDB
                ).build()
                appInstance = instance
                return instance
            }
        }
    }
}