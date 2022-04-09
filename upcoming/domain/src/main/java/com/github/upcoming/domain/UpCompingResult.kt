package com.github.upcoming.domain

import com.github.upcoming.domain.model.Movie

sealed class UpCompingResult {
    object Empty : UpCompingResult()
    data class Movies(val movies: List<Movie>) : UpCompingResult()
}
