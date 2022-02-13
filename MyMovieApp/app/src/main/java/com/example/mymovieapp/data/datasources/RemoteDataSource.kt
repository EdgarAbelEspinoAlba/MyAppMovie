package com.example.mymovieapp.data.datasources

import com.example.mymovieapp.domain.Movie

interface RemoteDataSource {
   suspend fun getPopularMovies(apiKey: String): List<Movie>
}