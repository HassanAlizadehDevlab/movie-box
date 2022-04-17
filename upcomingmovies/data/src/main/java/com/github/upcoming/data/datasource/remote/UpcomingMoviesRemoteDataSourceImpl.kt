package com.github.upcoming.data.datasource.remote

import com.github.upcoming.data.api.UpcomingMoviesApi
import com.github.upcoming.data.model.remote.UpcomingMovieJson
import javax.inject.Inject

class UpcomingMoviesRemoteDataSourceImpl @Inject constructor(
    private val upcomingMoviesApi: UpcomingMoviesApi
) : UpcomingMoviesRemoteDataSource {

    override suspend fun getMovies(): List<UpcomingMovieJson>? {
        return upcomingMoviesApi.getMovies().results
    }
}