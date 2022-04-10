package com.github.upcoming.data

import com.github.upcoming.data.model.remote.MovieJson
import com.github.upcoming.data.remote.UpcomingRemoteDataSource
import com.github.upcoming.domain.repository.UpcomingRepository
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
class UpcomingRepositoryImplTest {


    private lateinit var upcomingRemoteDataSource: UpcomingRemoteDataSource
    private lateinit var repository: UpcomingRepository

    @Before
    fun setup() {
        upcomingRemoteDataSource = mockk()
        repository = UpcomingRepositoryImpl(upcomingRemoteDataSource)
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

        coEvery { upcomingRemoteDataSource.getMovies() } returns movies

        val result = repository.getMovies()

        assert(!result.isNullOrEmpty())
        coVerify { upcomingRemoteDataSource.getMovies() }
    }

    @Test
    fun `when movie list is empty or null, just return null`() = runTest {
        val movies = null
        coEvery { upcomingRemoteDataSource.getMovies() } returns movies

        val result = repository.getMovies()

        assert(result == null)
    }

    @Test(expected = IOException::class)
    fun `when it gets exception, just don't catch it to be passed to upper layers`() = runTest {

        coEvery { upcomingRemoteDataSource.getMovies() } throws IOException()

        repository.getMovies()
    }

}