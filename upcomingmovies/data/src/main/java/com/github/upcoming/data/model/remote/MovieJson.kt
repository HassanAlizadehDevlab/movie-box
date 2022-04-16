package com.github.upcoming.data.model.remote

data class MovieJson(
    val id: Int,
    val title: String,
    val release_date: String?,
    val vote_average: Float,
    val backdrop_path: String?
)