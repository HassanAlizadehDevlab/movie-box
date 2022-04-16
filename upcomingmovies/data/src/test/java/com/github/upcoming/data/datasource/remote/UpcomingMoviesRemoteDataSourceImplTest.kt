package com.github.upcoming.data.datasource.remote

import com.github.upcoming.data.api.UpcomingMoviesApi
import com.github.upcoming.data.api.UpcomingMoviesResponse
import com.github.upcoming.data.model.remote.MovieJson
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
class UpcomingMoviesRemoteDataSourceImplTest {


    private lateinit var upcomingMoviesApi: UpcomingMoviesApi
    private lateinit var moviesRemote: UpcomingMoviesRemoteDataSource

    @Before
    fun setup() {
        upcomingMoviesApi = mockk()
        moviesRemote = UpcomingMoviesRemoteDataSourceImpl(upcomingMoviesApi)
    }

    @After
    fun teardown() {
        unmockkAll()
    }

    @Test
    fun `when movie list is available, just return it`() = runTest {

        val movie1 = MovieJson(
            id = 283552,
            title = "The Light Between Oceans",
            releaseDate = "2016-09-02",
            rate = 4.41f,
            image = "/pEFRzXtLmxYNjGd0XqJDHPDFKB2.jpg"
        )
        val movie2 = MovieJson(
            id = 342521,
            title = "Keanu",
            releaseDate = "2016-09-14",
            rate = 6.04f,
            image = "/udU6t5xPNDLlRTxhjXqgWFFYlvO.jpg"
        )
        val movies = listOf(movie1, movie2)
        coEvery { upcomingMoviesApi.getMovies() } returns UpcomingMoviesResponse(movies)

        val result = moviesRemote.getMovies()

        assert(!result.isNullOrEmpty())
        coVerify { upcomingMoviesApi.getMovies() }
    }

    @Test
    fun `when movie list is null, just return it`() = runTest {

        val movies = null
        coEvery { upcomingMoviesApi.getMovies() } returns UpcomingMoviesResponse(movies)

        val result = moviesRemote.getMovies()

        assert(result == null)
    }

    @Test(expected = IOException::class)
    fun `when it gets exception, just don't catch it to be passed to upper layers`() = runTest {

        coEvery { upcomingMoviesApi.getMovies() } throws IOException()

        moviesRemote.getMovies()
    }

}