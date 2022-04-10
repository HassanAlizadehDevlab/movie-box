package com.github.upcoming.data.api

import com.github.upcoming.data.model.remote.MovieJson

interface UpcomingMovieApi {

    suspend fun getMovies(): List<MovieJson>?
}
