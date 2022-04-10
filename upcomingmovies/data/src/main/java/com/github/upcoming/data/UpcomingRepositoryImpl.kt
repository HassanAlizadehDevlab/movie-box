package com.github.upcoming.data

import com.github.upcoming.data.datasource.remote.UpcomingRemoteDataSource
import com.github.upcoming.domain.model.Movie
import com.github.upcoming.domain.repository.UpcomingRepository

class UpcomingRepositoryImpl(
    private val upcomingRemoteDataSource: UpcomingRemoteDataSource
) : UpcomingRepository {

    override suspend fun getMovies(): List<Movie>? {
        return upcomingRemoteDataSource.getMovies()?.map {
            Movie(it.id, it.title, it.releaseDate, it.rate, it.image)
        }
    }
}
