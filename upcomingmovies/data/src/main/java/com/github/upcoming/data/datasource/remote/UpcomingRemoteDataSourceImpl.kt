package com.github.upcoming.data.datasource.remote

import com.github.upcoming.data.api.UpcomingMovieApi
import com.github.upcoming.data.model.remote.MovieJson

class UpcomingRemoteDataSourceImpl(
    private val upcomingMovieApi: UpcomingMovieApi
    ) : UpcomingRemoteDataSource {

    override suspend fun getMovies(): List<MovieJson>? {
        return upcomingMovieApi.getMovies()
    }

}