package com.example.chooseyoufavorite.model.movies

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CinemaDTO(
    val id: Int,
    val title: String?,
    val release_date: String?,
    val vote_average: String?,
    val budget: Int?,
    val revenue: Int?,
    val poster_path: String?,
    val backdrop_path: String?,
    val overview: String?,
    var note: String?,
    var isLike: Byte? = 0
): Parcelable