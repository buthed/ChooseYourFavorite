package com.example.chooseyoufavorite.app

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.chooseyoufavorite.data.room.CategoriesDatabase


class App : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        @Volatile
        private var INSTANCE: CategoriesDatabase? = null

        fun getDatabase(context: Context): CategoriesDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CategoriesDatabase::class.java,
                    "ChooseYourFavoriteDB"
                ).createFromAsset("database/ChooseYourFavorite.db")
                    .allowMainThreadQueries() //TODO
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}