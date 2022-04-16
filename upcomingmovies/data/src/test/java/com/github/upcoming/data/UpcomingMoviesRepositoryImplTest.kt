package com.github.upcoming.data

import com.github.upcoming.data.datasource.remote.UpcomingMoviesRemoteDataSource
import com.github.upcoming.data.model.remote.MovieJson
import com.github.upcoming.domain.repository.UpcomingMoviesRepository
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
class UpcomingMoviesRepositoryImplTest {


    private lateinit var upcomingMoviesRemoteDataSource: UpcomingMoviesRemoteDataSource
    private lateinit var repository: UpcomingMoviesRepository

    @Before
    fun setup() {
        upcomingMoviesRemoteDataSource = mockk()
        repository = UpcomingMoviesRepositoryImpl(upcomingMoviesRemoteDataSource)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }


    @Test
    fun `when movie list is available, just return it`() = runTest {
        val movie1 = MovieJson(
            id = 283552,
            title = "The Light Between Oceans",
            release_date = "2016-09-02",
            vote_average = 4.41f,
            backdrop_path = "/pEFRzXtLmxYNjGd0XqJDHPDFKB2.jpg"
        )
        val movie2 = MovieJson(
            id = 342521,
            title = "Keanu",
            release_date = "2016-09-14",
            vote_average = 6.04f,
            backdrop_path = "/udU6t5xPNDLlRTxhjXqgWFFYlvO.jpg"
        )
        val movies = listOf(movie1, movie2)

        coEvery { upcomingMoviesRemoteDataSource.getMovies() } returns movies

        val result = repository.getMovies()

        assert(!result.isNullOrEmpty())
        coVerify { upcomingMoviesRemoteDataSource.getMovies() }
    }

    @Test
    fun `when movie list is null, just return null`() = runTest {
        val movies = null
        coEvery { upcomingMoviesRemoteDataSource.getMovies() } returns movies

        val result = repository.getMovies()

        assert(result == null)
    }

    @Test(expected = IOException::class)
    fun `when it gets exception, just don't catch it to be passed to upper layers`() = runTest {

        coEvery { upcomingMoviesRemoteDataSource.getMovies() } throws IOException()

        repository.getMovies()
    }

    @Test
    fun `on result success, check images are w780`() = runTest {
        val movie1 = MovieJson(
            id = 283552,
            title = "The Light Between Oceans",
            release_date = "2016-09-02",
            vote_average = 4.41f,
            backdrop_path = "/pEFRzXtLmxYNjGd0XqJDHPDFKB2.jpg"
        )
        val movie2 = MovieJson(
            id = 342521,
            title = "Keanu",
            release_date = "2016-09-14",
            vote_average = 6.04f,
            backdrop_path = "/udU6t5xPNDLlRTxhjXqgWFFYlvO.jpg"
        )
        val movies = listOf(movie1, movie2)

        coEvery { upcomingMoviesRemoteDataSource.getMovies() } returns movies

        val result = repository.getMovies()

        result!!.forEach { movie -> assert(movie.image!!.contains("w780")) }
    }

}