package com.example.chooseyoufavorite.repository


import com.example.chooseyoufavorite.model.movies.CinemaDTO
import com.example.chooseyoufavorite.model.movies.TMDB_API_CINEMA_URL_END_POINT
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CinemaAPI {
    @GET("$TMDB_API_CINEMA_URL_END_POINT{id}")
    fun getCinema(
        @Path("id") id: Int,
        @Query("api_key") key: String = "3ecf2512edd67e7138c00bb4d44064d9"
    ): Call<CinemaDTO>
}