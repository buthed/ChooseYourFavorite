package com.example.chooseyoufavorite.di

import com.example.chooseyoufavorite.Models.Repository.Repository
import com.example.chooseyoufavorite.Models.Repository.RepositoryImpl
import com.example.chooseyoufavorite.ViewModel.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<Repository> { RepositoryImpl() }

    //View models
    viewModel { MovieViewModel(get()) }
}