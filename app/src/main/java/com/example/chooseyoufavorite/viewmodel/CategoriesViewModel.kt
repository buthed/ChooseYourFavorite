package com.example.chooseyoufavorite.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.chooseyoufavorite.app.App
import com.example.chooseyoufavorite.repository.CategoryRepositoryImpl

class CategoriesViewModel(
    application: Application
) : AndroidViewModel(application) {
    private val liveDataObserver: MutableLiveData<AppStateCategByType> = MutableLiveData()
    private val categoryRepository: CategoryRepositoryImpl =
        CategoryRepositoryImpl(App.getDatabase(application))

    fun getLiveData() = liveDataObserver

    fun getCategoriesByType(categoryName: String){
        liveDataObserver.value = AppStateCategByType.Loading
        liveDataObserver.value = AppStateCategByType
            .Success(categoryRepository.getAllCategoriesByType(categoryName))
    }
}
