package com.github.popularmovies.data

import com.github.popular.domain.model.PopularMovie
import com.github.popular.domain.repository.PopularMoviesRepository
import com.github.popularmovies.data.datasource.remote.PopularMoviesRemoteDataSource

class PopularMoviesRepositoryImpl(
    private val popularMoviesRemoteDataSource: PopularMoviesRemoteDataSource
) : PopularMoviesRepository {

    override suspend fun getMovies(): List<PopularMovie>? {
        return popularMoviesRemoteDataSource.getMovies()?.map { movie ->
            PopularMovie(
                id = movie.id,
                title = movie.title,
                releaseDate = movie.release_date,
                rate = movie.vote_average,
                image = getW500Image(movie.poster_path)
            )
        }
    }

    private fun getW500Image(image: String?): String? {
        if (image.isNullOrEmpty()) return null
        return "https://image.tmdb.org/t/p/w500$image"
    }

}
