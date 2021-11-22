package com.example.chooseyoufavorite.app

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.chooseyoufavorite.data.room.CategoriesDatabase
import com.example.chooseyoufavorite.data.room.categories.CategoriesDao
import com.example.chooseyoufavorite.data.room.categories.CategoriesTypeDao


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
//    companion object {
//        private var appInstance : App? = null
//        private var db: CategoriesDatabase? = null
//        private var nameDB = "ChooseYourFavoriteDB"
//
//        fun getDatabase():CategoriesTypeDao { //FIXME
//            if (db == null) {
//                val builder = Room.databaseBuilder(
//                    appInstance!!.applicationContext,
//                    CategoriesDatabase::class.java,
//                    nameDB
//                ).createFromAsset("database/ChooseYourFavorite.db")
//                db = builder.build()
//            }
//            return db!!.categoriesTypeDao()
//        }
//        fun getDatabase1():CategoriesDao { //FIXME
//            if (db == null) {
//                val builder = Room.databaseBuilder(
//                    appInstance!!.applicationContext,
//                    CategoriesDatabase::class.java,
//                    nameDB
//                ).createFromAsset("database/ChooseYourFavorite.db")
//                db = builder.build()
//            }
//            return db!!.categoriesDao()
//        }
//
//
//    }

}