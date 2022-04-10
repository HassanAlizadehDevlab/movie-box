package com.github.upcoming.data.datasource.remote

import com.github.upcoming.data.model.remote.MovieJson

interface UpcomingMoviesRemoteDataSource {
    suspend fun getMovies(): List<MovieJson>?
}
