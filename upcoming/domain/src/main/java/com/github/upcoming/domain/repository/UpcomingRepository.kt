package com.github.upcoming.domain.repository

import com.github.upcoming.domain.model.Movie

interface UpcomingRepository {
    suspend fun getMovies(): List<Movie>?
}
