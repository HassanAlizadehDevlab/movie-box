package com.github.domain

interface GetPopularMoviesUseCase {
    suspend fun execute(): PopularMoviesResult
}
