package com.example.chooseyoufavorite.datasource.room.categories.topHorrors

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TopHorrorsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val movie_id: Int?,
    val title: String?,
)
