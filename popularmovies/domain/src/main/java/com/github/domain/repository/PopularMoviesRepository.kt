package com.github.domain.repository

import com.github.domain.model.PopularMovie

interface PopularMoviesRepository {
    suspend fun getMovies(): List<PopularMovie>?
}
