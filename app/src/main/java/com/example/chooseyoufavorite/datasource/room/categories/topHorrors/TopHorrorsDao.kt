package com.example.chooseyoufavorite.datasource.room.categories.topHorrors

import androidx.room.Dao
import androidx.room.Query

@Dao
interface TopHorrorsDao {

    @Query("SELECT * FROM TopHorrorsEntity")
    fun selectAll(): List<TopHorrorsEntity>
}