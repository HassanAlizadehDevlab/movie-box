package com.github.upcoming.data.remote

import com.github.upcoming.data.model.remote.MovieJson

interface UpcomingRemoteDataSource {
    suspend fun getMovies(): List<MovieJson>?
}
