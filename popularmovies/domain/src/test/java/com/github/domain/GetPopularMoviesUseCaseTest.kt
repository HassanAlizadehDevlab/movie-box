package com.github.domain

import com.github.domain.model.PopularMovie
import com.github.domain.repository.PopularMoviesRepository
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
class GetPopularMoviesUseCaseTest {


    private lateinit var usecase: GetPopularMoviesUseCase
    private lateinit var popularMoviesRepository: PopularMoviesRepository

    @Before
    fun setup() {
        popularMoviesRepository = mockk()
        usecase = GetPopularMoviesUseCaseImpl(popularMoviesRepository)
    }

    @After
    fun teardown() {
        unmockkAll()
    }


    @Test
    fun `call to get popular movies, if result is empty then usecase returns Empty state as a result`() =
        runTest {
            val movies = listOf<PopularMovie>()
            coEvery { popularMoviesRepository.getMovies() } returns movies

            val result = usecase.execute()

            coVerify { popularMoviesRepository.getMovies() }
            assert(result == PopularMoviesResult.Empty)
        }

    @Test
    fun `call to get popular movies, if result is null then usecase returns Empty state as a result`() =
        runTest {
            coEvery { popularMoviesRepository.getMovies() } returns null

            val result = usecase.execute()

            coVerify { popularMoviesRepository.getMovies() }
            assert(result == PopularMoviesResult.Empty)
        }

    @Test
    fun `call to get popular movies, if result is not empty or null then usecase returns Empty state as a result`() =
        runTest {
            coEvery { popularMoviesRepository.getMovies() } returns null

            val result = usecase.execute()

            assert(result == PopularMoviesResult.Empty)
        }

    @Test
    fun `when popular movies has items, return the Movies sealed class item`() = runTest {

        val movie1 = PopularMovie(
            id = 283552,
            title = "The Light Between Oceans",
            releaseDate = "2016-09-02",
            rate = 4.41f,
            image = "/pEFRzXtLmxYNjGd0XqJDHPDFKB2.jpg"
        )
        val movie2 = PopularMovie(
            id = 342521,
            title = "Keanu",
            releaseDate = "2016-09-14",
            rate = 6.04f,
            image = "/udU6t5xPNDLlRTxhjXqgWFFYlvO.jpg"
        )
        val movies = listOf(movie1, movie2)
        coEvery { popularMoviesRepository.getMovies() } returns movies

        val result = usecase.execute()

        assert(result == PopularMoviesResult.Movies(movies))
    }
}