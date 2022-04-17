package com.github.popular.domain.repository

import com.github.popular.domain.model.PopularMovie

interface PopularMoviesRepository {
    suspend fun getMovies(): List<PopularMovie>?
}
