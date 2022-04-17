package com.github.domain

import com.github.domain.model.PopularMovie

sealed class PopularMoviesResult {
    data class Movies(val movies: List<PopularMovie>) : PopularMoviesResult()
    object Empty : PopularMoviesResult()
}
