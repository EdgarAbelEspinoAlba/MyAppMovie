package com.example.mymovieapp.framework.data.datasources

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieRemoteService {

    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun listAllMovies(
        @Query("api_key") apiKey: String
    ): MovieDbResult
}