package com.github.upcoming.data.datasource.remote

import com.github.upcoming.data.api.UpcomingMovieApi
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
class UpcomingRemoteDataSourceTest {


    private lateinit var upcomingMovieApi: UpcomingMovieApi
    private lateinit var remote: UpcomingRemoteDataSource

    @Before
    fun setup() {
        upcomingMovieApi = mockk()
        remote = UpcomingRemoteDataSourceImpl(upcomingMovieApi)
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
        coEvery { upcomingMovieApi.getMovies() } returns movies

        val result = remote.getMovies()

        assert(!result.isNullOrEmpty())
        coVerify { upcomingMovieApi.getMovies() }
    }

    @Test
    fun `when movie list is null, just return it`() = runTest {

        val movies = null
        coEvery { upcomingMovieApi.getMovies() } returns movies

        val result = remote.getMovies()

        assert(result == null)
    }

    @Test(expected = IOException::class)
    fun `when it gets exception, just don't catch it to be passed to upper layers`() = runTest {

        coEvery { upcomingMovieApi.getMovies() } throws IOException()

        remote.getMovies()
    }

}