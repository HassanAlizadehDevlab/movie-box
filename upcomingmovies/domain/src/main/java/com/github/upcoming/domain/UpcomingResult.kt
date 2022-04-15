package com.github.upcoming.domain

import com.github.upcoming.domain.model.Movie

sealed class UpcomingResult {
    object Empty : UpcomingResult()
    data class Movies(val movies: List<Movie>) : UpcomingResult()
}
