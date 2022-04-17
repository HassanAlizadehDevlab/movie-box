package com.github.upcoming.domain

import com.github.upcoming.domain.model.UpcomingMovie

sealed class UpcomingResult {
    object Empty : UpcomingResult()
    data class Movies(val movies: List<UpcomingMovie>) : UpcomingResult()
}
