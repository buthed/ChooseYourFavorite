package com.example.chooseyoufavorite.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.chooseyoufavorite.app.App
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
