package com.github.upcoming.datadi

import com.github.network.APIBuilder
import com.github.upcoming.data.api.UpcomingMoviesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object APIModule {

    @Provides
    fun provideUpcomingApi() : UpcomingMoviesApi {
        return APIBuilder.create(UpcomingMoviesApi::class.java)
    }
}