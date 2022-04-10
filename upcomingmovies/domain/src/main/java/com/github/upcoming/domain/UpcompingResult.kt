package com.github.upcoming.domain

import com.github.upcoming.domain.model.Movie

sealed class UpcompingResult {
    object Empty : UpcompingResult()
    data class Movies(val movies: List<Movie>) : UpcompingResult()
}
