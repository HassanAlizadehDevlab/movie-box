package com.github.upcoming.domain

import com.github.upcoming.domain.model.Movie
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

@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class GetUpcomingUseCaseTest {


    private lateinit var useCase: GetUpcomingUseCase
    private lateinit var upcomingRepository: UpcomingRepository
    private lateinit var upcomingOutputBoundary: UpcomingOutputBoundary

    @Before
    fun setup() {
        upcomingRepository = mockk()
        upcomingOutputBoundary = mockk()
        useCase = GetUpcomingUseCaseImpl(upcomingRepository)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `when upcoming movies is a empty list, return an Empty sealed class item`() = runTest {

        coEvery { upcomingRepository.getMovies() } returns listOf()
        coEvery { upcomingOutputBoundary.present(UpcompingResult.Empty) } returns Unit

        useCase.execute(upcomingOutputBoundary)

        coVerify { upcomingRepository.getMovies() }
        coVerify { upcomingOutputBoundary.present(UpcompingResult.Empty) }
    }

    @Test
    fun `when upcoming movies has items, return the Movies sealed class item`() = runTest {

        val movie1 = Movie(id = 283552, title = "The Light Between Oceans", releaseDate = "2016-09-02", rate = 4.41f, image = "/pEFRzXtLmxYNjGd0XqJDHPDFKB2.jpg")
        val movie2 = Movie(id = 342521, title = "Keanu", releaseDate = "2016-09-14", rate = 6.04f, image = "/udU6t5xPNDLlRTxhjXqgWFFYlvO.jpg")
        val movies = listOf(movie1, movie2)
        coEvery { upcomingRepository.getMovies() } returns movies
        coEvery { upcomingOutputBoundary.present(UpcompingResult.Movies(movies)) } returns Unit

        useCase.execute(upcomingOutputBoundary)

        coVerify { upcomingOutputBoundary.present(UpcompingResult.Movies(movies)) }
    }

}