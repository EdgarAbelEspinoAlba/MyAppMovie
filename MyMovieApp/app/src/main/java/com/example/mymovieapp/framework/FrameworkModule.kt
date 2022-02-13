package com.example.mymovieapp.framework

import com.example.mymovieapp.data.datasources.RemoteDataSource
import com.example.mymovieapp.framework.data.datasources.MovieRemoteService
import com.example.mymovieapp.framework.data.datasources.ServerMovieDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FrameworkModule {
    @Provides
    @Singleton
    @Named("baseUrl")
    fun baseUrlProvider() = "https://api.themoviedb.org/3/"

    @Provides
    @Singleton
    @Named("apiKey")
    fun apikeyProvider(): String = "d30e1f350220f9aad6c4110df385d380"

    @Provides
    @Singleton
    fun retrofitProvider(@Named("baseUrl")baseUrl: String) : Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun movieRemoteServiceProvider(retrofit: Retrofit): MovieRemoteService =
        retrofit.create(MovieRemoteService::class.java)

    @Provides
    fun remoteDataSourceProvider(movieRemoteService: MovieRemoteService): RemoteDataSource {
        return ServerMovieDataSource(movieRemoteService)
    }
}