package com.example.chooseyoufavorite.repository

import com.example.chooseyoufavorite.model.movies.Cinema

interface Repository {
    fun getCinemaListFromLocalSource(): Cinema
}