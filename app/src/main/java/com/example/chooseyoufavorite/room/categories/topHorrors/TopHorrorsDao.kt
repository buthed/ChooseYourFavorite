package com.example.chooseyoufavorite.room.categories.topHorrors

import androidx.room.Query


interface TopHorrorsDao {

    @Query("SELECT * FROM TopHorrorsEntity")
    fun selectAll(): List<TopHorrorsEntity>
}