package com.github.popularmovies.data.api

import com.github.popularmovies.data.model.remote.PopularMoviesJsonResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface PopularMoviesApi {
    @GET("movie/popular")
    suspend fun getMovies(
        @QueryMap query: Map<String, String> = mapOf("api_key" to "6ad511df129fee61d0e59d96b19301e8")
    ): PopularMoviesJsonResponse
}