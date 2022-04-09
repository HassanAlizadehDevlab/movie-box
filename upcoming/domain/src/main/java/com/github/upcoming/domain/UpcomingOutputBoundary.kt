package com.github.upcoming.domain

interface UpcomingOutputBoundary {
    suspend fun present(result: UpCompingResult)
}
