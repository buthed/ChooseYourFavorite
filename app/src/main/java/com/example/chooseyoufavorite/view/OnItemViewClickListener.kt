package com.example.chooseyoufavorite.view

import com.example.chooseyoufavorite.model.movies.CinemaDTO

interface OnItemViewClickListener {
    fun onItemViewClick(cinema: CinemaDTO)
}
