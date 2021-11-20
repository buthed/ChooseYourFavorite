package com.example.chooseyoufavorite.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.chooseyoufavorite.data.room.CategoriesDatabase
import com.example.chooseyoufavorite.data.room.categories.CategoriesEntity
import com.example.chooseyoufavorite.repository.CategoryRepository


class CategoriesViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<CategoriesEntity>>
    private val repository: CategoryRepository

    init {
        val categoriesDao = CategoriesDatabase.getCategoriesDatabase(
            application
        ).categoriesDao()
        repository = CategoryRepository(categoriesDao)
        readAllData = repository.readAllData
    }
}