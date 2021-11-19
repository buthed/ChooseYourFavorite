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

    companion object {
        @Volatile
        private var INSTANCE: CategoriesDatabase? = null

        fun getCategoriesDatabase(context: Context): CategoriesDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CategoriesDatabase::class.java,
                    "ChooseYourFavoriteDB"
                ).createFromAsset("database/ChooseYourFavorite.db").build()
                INSTANCE = instance
                return instance
            }
        }
    }


//    companion object {
//        private var appInstance : App? = null
//        private var db: CategoriesDatabase? = null
//        private var nameDB = "CategoriesDB"
//
//        fun getCategoriesDatabase():CategoriesDao{ //FIXME
//            if (db== null) {
//                val builder = Room.databaseBuilder(
//                    appInstance!!.applicationContext,
//                    CategoriesDatabase::class.java,
//                    nameDB
//                ).createFromAsset("database/ChooseYourFavorite.db")
//                db = builder.allowMainThreadQueries().build()
//            }
//            return db!!.categoriesDao()
//        }
//    }
}