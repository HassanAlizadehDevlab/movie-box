package com.github.upcoming.domain

import com.github.upcoming.domain.repository.UpcomingMoviesRepository
import javax.inject.Inject

class GetUpcomingMoviesUseCaseImpl @Inject constructor(
    private val upcomingMoviesRepository: UpcomingMoviesRepository
) : GetUpcomingMoviesUseCase {

    override suspend fun execute(): UpcomingResult {
        val movies = upcomingMoviesRepository.getMovies()
        return if (movies.isNullOrEmpty()) UpcomingResult.Empty else UpcomingResult.Movies(movies)
    }
}