package com.example.mymovieapp.data.repositories

import com.example.mymovieapp.domain.Movie
import com.example.mymovieapp.data.datasources.RemoteDataSource
import javax.inject.Named

class MovieRepository(private val remoteDataSource: RemoteDataSource,
                      @Named("apiKey") private val apiKey: String) {
  suspend fun getAllMovies(): List<Movie> = remoteDataSource.getPopularMovies(apiKey)
}