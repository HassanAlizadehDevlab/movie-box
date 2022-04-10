package com.github.upcoming.datadi

import com.github.upcoming.data.UpcomingMoviesRepositoryImpl
import com.github.upcoming.data.datasource.remote.UpcomingMoviesRemoteDataSource
import com.github.upcoming.data.datasource.remote.UpcomingMoviesRemoteDataSourceImpl
import com.github.upcoming.domain.repository.UpcomingMoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindUpcomingRemoteDataSource(impl: UpcomingMoviesRemoteDataSourceImpl): UpcomingMoviesRemoteDataSource

    @Binds
    abstract fun bindUpcomingRepository(impl: UpcomingMoviesRepositoryImpl): UpcomingMoviesRepository
}