package com.github.upcoming.domain_di

import com.github.upcoming.domain.GetUpcomingMoviesUseCase
import com.github.upcoming.domain.GetUpcomingMoviesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindGetUpcomingMoviesUseCase(impl: GetUpcomingMoviesUseCaseImpl): GetUpcomingMoviesUseCase
}