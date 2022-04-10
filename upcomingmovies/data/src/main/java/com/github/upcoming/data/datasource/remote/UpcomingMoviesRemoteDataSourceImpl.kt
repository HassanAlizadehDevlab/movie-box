package com.github.upcoming.data.datasource.remote

import com.github.upcoming.data.api.UpcomingMoviesApi
import com.github.upcoming.data.model.remote.MovieJson
import javax.inject.Inject

class UpcomingMoviesRemoteDataSourceImpl @Inject constructor(
    private val upcomingMoviesApi: UpcomingMoviesApi
) : UpcomingMoviesRemoteDataSource {

    override suspend fun getMovies(): List<MovieJson>? {
        return upcomingMoviesApi.getMovies()
    }
}