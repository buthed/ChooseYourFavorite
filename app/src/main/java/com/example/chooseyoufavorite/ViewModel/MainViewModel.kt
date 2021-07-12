package com.example.chooseyoufavorite.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chooseyoufavorite.ARG_OBJECT
import com.example.chooseyoufavorite.Models.AppState
import com.example.chooseyoufavorite.Models.Repository.Repository
import java.lang.Thread.sleep

class MainViewModel(private val repository : Repository) : ViewModel() {
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()

    fun getLiveData() = liveDataToObserve

    fun getCinemaList(currentCategory: String) = getDataFromLocalSource(currentCategory)

    private fun getDataFromLocalSource(currentCategory: String) {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(
                AppState.Success(
                    when (currentCategory) {
                        "Movie" -> repository.getCategoryFromLocalStorageMovie()
                        "Music" -> repository.getCategoryFromLocalStorageMusic()
                        else -> repository.getCategoryFromLocalStorageMovie()
                    }
                )
            )
        }.start()
    }
}