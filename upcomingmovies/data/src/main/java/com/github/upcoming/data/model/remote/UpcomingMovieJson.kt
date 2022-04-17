package com.github.upcoming.data.model.remote

data class UpcomingMovieJson(
    val id: Int,
    val title: String,
    val poster_path: String?,
    val vote_average: Float,
    val backdrop_path: String?
)