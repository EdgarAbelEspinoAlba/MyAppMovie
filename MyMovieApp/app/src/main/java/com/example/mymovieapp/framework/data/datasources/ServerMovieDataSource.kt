package com.example.mymovieapp.framework.data.datasources

import com.example.mymovieapp.data.datasources.RemoteDataSource
import com.example.mymovieapp.domain.Movie as DomainMovie
import com.example.mymovieapp.framework.data.datasources.ServerMovie as ServerMovie

class ServerMovieDataSource(
    private val movieRemoteService: MovieRemoteService
) : RemoteDataSource {
    override suspend fun getPopularMovies(apiKey: String): List<DomainMovie> {
        val moviesResult = movieRemoteService.listAllMovies(apiKey)
        return moviesResult.results.map { movie: ServerMovie ->
            DomainMovie(
                movie.id,
                movie.title,
                movie.overview,
                movie.releaseDate,
                movie.posterPath,
                movie.backdropPath,
                movie.originalLanguage,
                movie.originalLanguage,
                movie.popularity,
                movie.voteAverage,
                movie.adult
            )
        }
    }
}