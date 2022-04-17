package com.github.popularmovies.data.datasource.remote

import com.github.popularmovies.data.model.remote.PopularMovieJson

interface PopularMoviesRemoteDataSource {
    suspend fun getMovies(): List<PopularMovieJson>?
}
