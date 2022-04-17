package com.github.upcoming.domain.repository

import com.github.upcoming.domain.model.UpcomingMovie

interface UpcomingMoviesRepository {
    suspend fun getMovies(): List<UpcomingMovie>?
}
