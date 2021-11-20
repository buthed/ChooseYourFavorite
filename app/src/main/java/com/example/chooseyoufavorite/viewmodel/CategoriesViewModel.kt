package com.example.chooseyoufavorite.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chooseyoufavorite.data.room.CategoriesDatabase
import com.example.chooseyoufavorite.data.room.categories.CategoriesEntity
import com.example.chooseyoufavorite.data.room.categories.CategoriesTypeDao_Impl
import com.example.chooseyoufavorite.repository.CategoryRepository
import com.example.chooseyoufavorite.view.categories.CategoriesFragment
import com.example.chooseyoufavorite.view.categories.CategoriesFragment.Companion.categoryKey


class CategoriesViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<CategoriesEntity>>
    private val repository: CategoryRepository


    init {
        val categoriesDao = CategoriesDatabase.getCategoriesDatabase(
            application
        ).categoriesDao()
        repository = CategoryRepository(categoriesDao, categoryKey)
        readAllData = repository.readAllData
    }


}