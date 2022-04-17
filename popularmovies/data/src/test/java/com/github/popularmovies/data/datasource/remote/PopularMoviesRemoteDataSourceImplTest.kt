package com.github.popularmovies.data.datasource.remote

import com.github.popularmovies.data.api.PopularMoviesApi
import com.github.popularmovies.data.model.remote.PopularMovieJson
import com.github.popularmovies.data.model.remote.PopularMoviesJsonResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.IOException

@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class PopularMoviesRemoteDataSourceImplTest {

    private lateinit var datasource: PopularMoviesRemoteDataSource
    private lateinit var popularMoviesApi: PopularMoviesApi

    @Before
    fun setup() {
        popularMoviesApi = mockk()
        datasource = PopularMoviesRemoteDataSourceImpl(popularMoviesApi)
    }

    @After
    fun teardown() {
        unmockkAll()
    }


    @Test
    fun `when popular movie list is available, just return it`() = runTest {

        val movie1 = PopularMovieJson(
            id = 283552,
            title = "The Light Between Oceans",
            release_date = "2016-09-02",
            vote_average = 4.41f,
            poster_path = "/pEFRzXtLmxYNjGd0XqJDHPDFKB2.jpg"
        )
        val movie2 = PopularMovieJson(
            id = 342521,
            title = "Keanu",
            release_date = "2016-09-14",
            vote_average = 6.04f,
            poster_path = "/udU6t5xPNDLlRTxhjXqgWFFYlvO.jpg"
        )
        val movies = listOf(movie1, movie2)

        coEvery { popularMoviesApi.getMovies() } returns PopularMoviesJsonResponse(movies)

        val result = datasource.getMovies()

        coVerify { popularMoviesApi.getMovies() }
        assert(result == movies)
    }

    @Test
    fun `when popular movie list is null, just return it`() = runTest {

        coEvery { popularMoviesApi.getMovies() } returns PopularMoviesJsonResponse(null)

        val result = datasource.getMovies()

        assert(result == null)
    }

    @Test(expected = IOException::class)
    fun `when it gets exception, just don't catch it to be passed to upper layers`() = runTest {

        coEvery { popularMoviesApi.getMovies() } throws IOException()

        datasource.getMovies()
    }
}