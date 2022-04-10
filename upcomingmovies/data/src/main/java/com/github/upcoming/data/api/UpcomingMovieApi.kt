package com.github.upcoming.data.api

import com.github.upcoming.data.model.remote.MovieJson
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface UpcomingMovieApi {

    @GET("/movie/upcoming")
    suspend fun getMovies(
        @QueryMap query: Map<String, String> = mapOf("api_key" to "6ad511df129fee61d0e59d96b19301e8")
    ): List<MovieJson>?
}
