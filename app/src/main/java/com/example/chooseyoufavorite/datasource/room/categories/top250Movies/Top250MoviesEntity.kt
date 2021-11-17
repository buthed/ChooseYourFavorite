package com.example.chooseyoufavorite.datasource.room.categories.top250Movies

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Top250MoviesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val movie_id: Int?,
    val title: String?,
)
