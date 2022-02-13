package com.example.mymovieapp.usescase

import com.example.mymovieapp.data.repositories.MovieRepository
import com.example.mymovieapp.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoadAllMovies(private val repository: MovieRepository) {
    suspend fun invoke(): List<Movie> = withContext(Dispatchers.IO){
        repository.getAllMovies()
    }
}