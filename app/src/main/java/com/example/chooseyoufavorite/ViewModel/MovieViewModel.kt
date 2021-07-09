package com.example.chooseyoufavorite.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chooseyoufavorite.Models.AppState
import com.example.chooseyoufavorite.Models.Repository.Repository
import java.lang.Thread.sleep

class MovieViewModel(private val repository : Repository) : ViewModel() {
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()

    fun getLiveData() = liveDataToObserve

    fun getCinemaList() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(
                AppState.Success(repository.getCategoryFromLocalStorage())
            )
        }.start()
    }
}