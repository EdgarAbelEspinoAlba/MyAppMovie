package com.example.mymovieapp.data

import com.example.mymovieapp.data.datasources.RemoteDataSource
import com.example.mymovieapp.data.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun movieRepositoryProvider(
        remoteDataSource: RemoteDataSource,
        @Named("apiKey") apiKey: String
    ): MovieRepository {
        return MovieRepository(remoteDataSource, apiKey)
    }
}