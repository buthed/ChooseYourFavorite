package com.example.chooseyoufavorite.repository

import com.example.chooseyoufavorite.model.movies.CinemaDTO
import retrofit2.Callback

class CinemaRepositoryImpl(private val remoteDataSource: RemoteDataSource): CinemaRepository {

    override fun getCinemaFromServer(id: Int, callback: Callback<CinemaDTO>) {
        remoteDataSource.getCinemaDetails(id, callback)
    }
}