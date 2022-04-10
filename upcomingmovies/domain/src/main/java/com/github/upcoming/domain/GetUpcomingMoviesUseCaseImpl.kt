package com.github.upcoming.domain

import com.github.upcoming.domain.repository.UpcomingMoviesRepository
import javax.inject.Inject

class GetUpcomingMoviesUseCaseImpl @Inject constructor(
    private val upcomingMoviesRepository: UpcomingMoviesRepository
) : GetUpcomingMoviesUseCase {

    override suspend fun execute(upcomingOutputBoundary: UpcomingOutputBoundary) {
        val movies = upcomingMoviesRepository.getMovies()
        if (movies.isNullOrEmpty()) upcomingOutputBoundary.present(UpcompingResult.Empty)
        else upcomingOutputBoundary.present(UpcompingResult.Movies(movies))
    }
}