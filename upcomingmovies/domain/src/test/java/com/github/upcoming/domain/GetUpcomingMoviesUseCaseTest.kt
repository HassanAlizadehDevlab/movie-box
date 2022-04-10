package com.github.upcoming.domain

import com.github.upcoming.domain.model.Movie
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
    private lateinit var upcomingOutputBoundary: UpcomingOutputBoundary

    @Before
    fun setup() {
        upcomingMoviesRepository = mockk()
        upcomingOutputBoundary = mockk()
        useCase = GetUpcomingMoviesUseCaseImpl(upcomingMoviesRepository)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `when upcoming movies is a empty list, return an Empty sealed class item`() = runTest {

        coEvery { upcomingMoviesRepository.getMovies() } returns listOf()
        coEvery { upcomingOutputBoundary.present(UpcompingResult.Empty) } returns Unit

        useCase.execute(upcomingOutputBoundary)

        coVerify { upcomingMoviesRepository.getMovies() }
        coVerify { upcomingOutputBoundary.present(UpcompingResult.Empty) }
    }

    @Test
    fun `when upcoming movies has items, return the Movies sealed class item`() = runTest {

        val movie1 = Movie(id = 283552, title = "The Light Between Oceans", releaseDate = "2016-09-02", rate = 4.41f, image = "/pEFRzXtLmxYNjGd0XqJDHPDFKB2.jpg")
        val movie2 = Movie(id = 342521, title = "Keanu", releaseDate = "2016-09-14", rate = 6.04f, image = "/udU6t5xPNDLlRTxhjXqgWFFYlvO.jpg")
        val movies = listOf(movie1, movie2)
        coEvery { upcomingMoviesRepository.getMovies() } returns movies
        coEvery { upcomingOutputBoundary.present(UpcompingResult.Movies(movies)) } returns Unit

        useCase.execute(upcomingOutputBoundary)

        coVerify { upcomingOutputBoundary.present(UpcompingResult.Movies(movies)) }
    }

}