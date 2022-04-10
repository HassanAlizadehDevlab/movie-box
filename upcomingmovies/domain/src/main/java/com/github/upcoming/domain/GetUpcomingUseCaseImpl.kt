package com.github.upcoming.domain

import com.github.upcoming.domain.repository.UpcomingMoviesRepository

class GetUpcomingUseCaseImpl(
    private val upcomingMoviesRepository: UpcomingMoviesRepository
) : GetUpcomingUseCase {

    override suspend fun execute(upcomingOutputBoundary: UpcomingOutputBoundary) {
        val movies = upcomingMoviesRepository.getMovies()
        if (movies.isNullOrEmpty()) upcomingOutputBoundary.present(UpcompingResult.Empty)
        else upcomingOutputBoundary.present(UpcompingResult.Movies(movies))
    }
}