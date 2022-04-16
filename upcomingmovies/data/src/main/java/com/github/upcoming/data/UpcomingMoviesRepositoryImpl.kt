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
            // TODO I need a mapper.
            Movie(it.id, it.title, it.release_date, it.vote_average, getW780Image(it.backdrop_path))
        }
    }


    private fun getW780Image(image: String?): String? {
        if (image.isNullOrEmpty()) return null
        return "https://image.tmdb.org/t/p/w780$image"
    }
}
