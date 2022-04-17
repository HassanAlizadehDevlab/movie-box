package com.github.domain

import com.github.domain.repository.PopularMoviesRepository

class GetPopularMoviesUseCaseImpl(
    private val popularMoviesRepository: PopularMoviesRepository
) : GetPopularMoviesUseCase {

    override suspend fun execute(): PopularMoviesResult {
        val movies = popularMoviesRepository.getMovies()
        return if (movies.isNullOrEmpty()) PopularMoviesResult.Empty else PopularMoviesResult.Movies(
            movies
        )
    }
}
