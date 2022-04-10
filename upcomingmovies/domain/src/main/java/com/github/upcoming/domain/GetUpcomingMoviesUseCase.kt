package com.github.upcoming.domain

interface GetUpcomingMoviesUseCase {
    suspend fun execute(upcomingOutputBoundary: UpcomingOutputBoundary)
}