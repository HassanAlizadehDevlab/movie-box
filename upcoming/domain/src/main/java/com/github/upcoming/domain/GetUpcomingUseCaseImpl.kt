package com.github.upcoming.domain

import com.github.upcoming.domain.repository.UpcomingRepository

class GetUpcomingUseCaseImpl(
    private val upcomingRepository: UpcomingRepository
) : GetUpcomingUseCase {

    override suspend fun execute(upcomingOutputBoundary: UpcomingOutputBoundary) {
        val movies = upcomingRepository.getMovies()
        if (movies.isNullOrEmpty()) upcomingOutputBoundary.present(UpCompingResult.Empty)
        else upcomingOutputBoundary.present(UpCompingResult.Movies(movies))
    }
}