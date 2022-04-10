package com.github.upcoming.domain

interface GetUpcomingUseCase {
    suspend fun execute(upcomingOutputBoundary: UpcomingOutputBoundary)
}