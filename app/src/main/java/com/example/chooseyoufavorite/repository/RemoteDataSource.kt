package com.example.chooseyoufavorite.repository

import com.example.chooseyoufavorite.model.movies.CinemaDTO
import com.example.chooseyoufavorite.model.movies.TMDB_API_CINEMA_URL
import com.google.gson.GsonBuilder
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {
    private val cinemaAPI = Retrofit.Builder()
        .baseUrl(TMDB_API_CINEMA_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build().create(CinemaAPI::class.java)

    fun getCinemaDetails(id: Int, callback: Callback<CinemaDTO>) {
        cinemaAPI.getCinema(id).enqueue(callback)
    }
}