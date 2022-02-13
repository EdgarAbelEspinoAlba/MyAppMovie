package com.example.mymovieapp.framework.ui.main

import com.example.mymovieapp.data.repositories.MovieRepository
import com.example.mymovieapp.usescase.LoadAllMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MainActivityModule {
    @Provides
    fun loadAllMoviesProvider(repository: MovieRepository): LoadAllMovies {
        return LoadAllMovies(repository)
    }
}