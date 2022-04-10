package com.github.upcoming.domain.repository

import com.github.upcoming.domain.model.Movie

interface UpcomingMoviesRepository {
    suspend fun getMovies(): List<Movie>?
}
