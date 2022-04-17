package com.github.popular.domain

import com.github.popular.domain.model.PopularMovie

sealed class PopularMoviesResult {
    data class Movies(val movies: List<PopularMovie>) : PopularMoviesResult()
    object Empty : PopularMoviesResult()
}
