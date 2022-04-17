package com.github.popularmovies.data_di

import com.github.popular.domain.repository.PopularMoviesRepository
import com.github.popularmovies.data.PopularMoviesRepositoryImpl
import com.github.popularmovies.data.datasource.remote.PopularMoviesRemoteDataSource
import com.github.popularmovies.data.datasource.remote.PopularMoviesRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindPopularMoviesRemoteDataSource(impl: PopularMoviesRemoteDataSourceImpl): PopularMoviesRemoteDataSource

    @Binds
    abstract fun bindPopularMoviesRepository(impl: PopularMoviesRepositoryImpl): PopularMoviesRepository

}