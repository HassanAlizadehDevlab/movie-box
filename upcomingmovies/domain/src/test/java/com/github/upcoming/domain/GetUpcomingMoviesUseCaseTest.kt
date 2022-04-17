package com.github.upcoming.domain

import com.github.upcoming.domain.model.UpcomingMovie
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

@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class GetUpcomingMoviesUseCaseTest {


    private lateinit var useCase: GetUpcomingMoviesUseCase
    private lateinit var upcomingMoviesRepository: UpcomingMoviesRepository

    @Before
    fun setup() {
        upcomingMoviesRepository = mockk()
        useCase = GetUpcomingMoviesUseCaseImpl(upcomingMoviesRepository)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `when upcoming movies is a empty list, return an Empty sealed class item`() = runTest {

        coEvery { upcomingMoviesRepository.getMovies() } returns listOf()

        val result = useCase.execute()

        coVerify { upcomingMoviesRepository.getMovies() }

        assert(result == UpcomingResult.Empty)
    }

    @Test
    fun `when upcoming movies has items, return the Movies sealed class item`() = runTest {

        val movie1 = UpcomingMovie(id = 283552, title = "The Light Between Oceans", releaseDate = "2016-09-02", rate = 4.41f, image = "/pEFRzXtLmxYNjGd0XqJDHPDFKB2.jpg")
        val movie2 = UpcomingMovie(id = 342521, title = "Keanu", releaseDate = "2016-09-14", rate = 6.04f, image = "/udU6t5xPNDLlRTxhjXqgWFFYlvO.jpg")
        val movies = listOf(movie1, movie2)
        coEvery { upcomingMoviesRepository.getMovies() } returns movies

        val result = useCase.execute()


        assert(result == UpcomingResult.Movies(movies))
    }

}