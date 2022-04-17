package com.github.popular.domain.model

data class PopularMovie(
    val id: Int,
    val title: String,
    val releaseDate: String?,
    val rate: Float,
    val image: String?
)
