package com.github.upcoming.data.datasource.remote

import com.github.upcoming.data.model.remote.UpcomingMovieJson

interface UpcomingMoviesRemoteDataSource {
    suspend fun getMovies(): List<UpcomingMovieJson>?
}
