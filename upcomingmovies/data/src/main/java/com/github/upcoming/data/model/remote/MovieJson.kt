package com.github.upcoming.data.model.remote

data class MovieJson(
    val id: Int,
    val title: String,
    val releaseDate: String?,
    val rate: Float,
    val image: String?
)