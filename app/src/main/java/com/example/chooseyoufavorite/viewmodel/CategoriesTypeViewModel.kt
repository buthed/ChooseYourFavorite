package com.example.chooseyoufavorite.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chooseyoufavorite.app.App
import com.example.chooseyoufavorite.data.room.CategoriesDatabase
import com.example.chooseyoufavorite.data.room.categories.CategoriesTypeEntity
import com.example.chooseyoufavorite.repository.CategoryTypeRepository
import com.example.chooseyoufavorite.repository.CategoryTypeRepositoryImpl


class CategoriesTypeViewModel(
    application: Application,
) : AndroidViewModel(application) {
    private val liveDataObserver: MutableLiveData<AppStateCateg> = MutableLiveData()
    private val categoryRepository: CategoryTypeRepositoryImpl =
        CategoryTypeRepositoryImpl(App.getDatabase(application))

    fun getLiveData() = liveDataObserver

    fun getCategories() {
        liveDataObserver.value = AppStateCateg.Loading
        liveDataObserver.value = AppStateCateg
            .Success(categoryRepository.getAllCategoriesTypes())
    }
}

//    val readAllData: LiveData<List<CategoriesTypeEntity>>
//    private val repository: CategoryTypeRepository
//    init {
//        val categoriesTypeDao = App.getDatabase(
//            application
//        ).categoriesTypeDao()
//        repository = CategoryTypeRepository(categoriesTypeDao)
//        readAllData = repository.getAllCategoriesTypes()
//    }
//
//}