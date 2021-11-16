package com.example.chooseyoufavorite.repository

import com.example.chooseyoufavorite.model.movies.CinemaDTO
import retrofit2.Callback

interface CinemaRepository {
    fun getCinemaFromServer(id: Int,callback: Callback<CinemaDTO>)
}