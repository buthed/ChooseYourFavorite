package com.example.chooseyoufavorite.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.chooseyoufavorite.app.App
import com.example.chooseyoufavorite.repository.GameRepositoryImpl

class GameViewModel(
    application: Application
) : AndroidViewModel(application) {
    private val liveDataObserver: MutableLiveData<AppStateCategGame> = MutableLiveData()
    private val gameRepository: GameRepositoryImpl =
        GameRepositoryImpl(App.getDatabase(application))

    fun getLiveData() = liveDataObserver

    fun getTop250Movies(){
        liveDataObserver.value = AppStateCategGame.Loading
        liveDataObserver.value = AppStateCategGame
            .Success(gameRepository.getTop250Movies())
    }
}
