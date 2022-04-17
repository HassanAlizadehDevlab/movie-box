package com.github.popularmovies.data_di

import com.github.network.APIBuilder
import com.github.popularmovies.data.api.PopularMoviesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object APIModule {

    @Provides
    fun providePopularMoviesAPI(): PopularMoviesApi {
        return APIBuilder.create(PopularMoviesApi::class.java)
    }
}