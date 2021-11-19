package com.example.chooseyoufavorite.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.chooseyoufavorite.data.room.CategoriesDatabase
import com.example.chooseyoufavorite.data.room.categories.CategoriesEntity
import com.example.chooseyoufavorite.data.room.categories.CategoriesTypeEntity
import com.example.chooseyoufavorite.repository.CategoryRepository
import com.example.chooseyoufavorite.repository.CategoryTypeRepository


class CategoriesTypeViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<CategoriesTypeEntity>>
    private val repository: CategoryTypeRepository

    init {
        val categoriesTypeDao = CategoriesDatabase.getCategoriesDatabase(
            application
        ).categoriesTypeDao()
        repository = CategoryTypeRepository(categoriesTypeDao)
        readAllData = repository.readDataCategoriesType
    }
}