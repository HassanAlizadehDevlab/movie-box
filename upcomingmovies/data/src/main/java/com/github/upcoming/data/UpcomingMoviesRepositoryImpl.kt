package com.github.upcoming.data

import com.github.upcoming.data.datasource.remote.UpcomingMoviesRemoteDataSource
import com.github.upcoming.domain.model.Movie
import com.github.upcoming.domain.repository.UpcomingMoviesRepository
import javax.inject.Inject

class UpcomingMoviesRepositoryImpl @Inject constructor(
    private val upcomingMoviesRemoteDataSource: UpcomingMoviesRemoteDataSource
) : UpcomingMoviesRepository {

    override suspend fun getMovies(): List<Movie>? {
        return upcomingMoviesRemoteDataSource.getMovies()?.map {
            Movie(it.id, it.title, it.releaseDate, it.rate, it.image)
        }
    }
}
