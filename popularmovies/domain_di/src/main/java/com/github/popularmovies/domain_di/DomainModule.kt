package com.github.popularmovies.domain_di

import com.github.popular.domain.GetPopularMoviesUseCase
import com.github.popular.domain.GetPopularMoviesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindGetPopularMoviesUseCase(impl: GetPopularMoviesUseCaseImpl): GetPopularMoviesUseCase

}