package com.github.upcoming.domain.model

data class UpcomingMovie(
    val id: Int,
    val title: String,
    val releaseDate: String?,
    val rate: Float,
    val image: String?
)
