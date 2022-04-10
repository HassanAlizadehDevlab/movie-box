package com.github.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIBuilder {

    private lateinit var retrofit: Retrofit

    init {
        createRetrofit()
    }

    fun <T> create(api: Class<T>): T {
        return retrofit.create(api)
    }

    private fun createRetrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}