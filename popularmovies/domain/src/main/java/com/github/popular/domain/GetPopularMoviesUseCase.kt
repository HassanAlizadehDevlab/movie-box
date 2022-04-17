package com.github.popular.domain

interface GetPopularMoviesUseCase {
    suspend fun execute(): PopularMoviesResult
}
