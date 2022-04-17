package com.github.popularmovies.data.datasource.remote

import com.github.popularmovies.data.api.PopularMoviesApi
import com.github.popularmovies.data.model.remote.PopularMovieJson

class PopularMoviesRemoteDataSourceImpl(
    private val popularMoviesApi: PopularMoviesApi
) : PopularMoviesRemoteDataSource {
    override suspend fun getMovies(): List<PopularMovieJson>? {
        return popularMoviesApi.getMovies().results
    }
}
