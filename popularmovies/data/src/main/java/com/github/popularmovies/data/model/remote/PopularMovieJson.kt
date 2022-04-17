package com.github.popularmovies.data.model.remote

data class PopularMovieJson(
    val id: Int,
    val title: String,
    val release_date: String?,
    val vote_average: Float,
    val poster_path: String?
)