package com.github.popularmovies.data

import com.github.popular.domain.model.PopularMovie
import com.github.popular.domain.repository.PopularMoviesRepository
import com.github.popularmovies.data.datasource.remote.PopularMoviesRemoteDataSource
import com.github.popularmovies.data.model.remote.PopularMovieJson
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
class PopularMoviesRepositoryImplTest {


    private lateinit var repository: PopularMoviesRepository
    private lateinit var popularMoviesRemoteDataSource: PopularMoviesRemoteDataSource

    @Before
    fun setup() {
        popularMoviesRemoteDataSource = mockk()
        repository = PopularMoviesRepositoryImpl(popularMoviesRemoteDataSource)
    }

    @After
    fun teardown() {
        unmockkAll()
    }


    @Test
    fun `when popular movie list is available, return it`() = runTest {
        val movie1 = PopularMovieJson(id = 283552, title = "The Light Between Oceans", release_date = "2016-09-02", vote_average = 4.41f, poster_path = "/pEFRzXtLmxYNjGd0XqJDHPDFKB2.jpg")
        val movie2 = PopularMovieJson(id = 342521, title = "Keanu", release_date = "2016-09-14", vote_average = 6.04f, poster_path = "/udU6t5xPNDLlRTxhjXqgWFFYlvO.jpg")
        val movies = listOf(movie1, movie2)

        coEvery { popularMoviesRemoteDataSource.getMovies() } returns movies

        val result = repository.getMovies()

        coVerify { popularMoviesRemoteDataSource.getMovies() }
        assert(!result.isNullOrEmpty())
    }

    @Test
    fun `when popular movie list is null, just return null`() = runTest {

        val movies = null
        coEvery { popularMoviesRemoteDataSource.getMovies() } returns movies

        val result = repository.getMovies()

        assert(result == null)
    }

    @Test(expected = IOException::class)
    fun `when it gets exception, just don't catch it to be passed to upper layers`() = runTest {
        coEvery { popularMoviesRemoteDataSource.getMovies() } throws IOException()

        repository.getMovies()
    }

    @Test
    fun `on result success, check images are w500`() = runTest {

        val movie1 = PopularMovieJson(id = 283552, title = "The Light Between Oceans", release_date = "2016-09-02", vote_average = 4.41f, poster_path = "/pEFRzXtLmxYNjGd0XqJDHPDFKB2.jpg")
        val movie2 = PopularMovieJson(id = 342521, title = "Keanu", release_date = "2016-09-14", vote_average = 6.04f, poster_path = "/udU6t5xPNDLlRTxhjXqgWFFYlvO.jpg")
        val movies = listOf(movie1, movie2)

        coEvery { popularMoviesRemoteDataSource.getMovies() } returns movies


        val result = repository.getMovies()

        assert(!result.isNullOrEmpty())
        result?.forEach { movie ->
            assert(movie.image?.contains("w500") == true)
        }
    }

    @Test
    fun `on result success, check images have a full path`() = runTest {

        val movie1 = PopularMovieJson(id = 283552, title = "The Light Between Oceans", release_date = "2016-09-02", vote_average = 4.41f, poster_path = "/pEFRzXtLmxYNjGd0XqJDHPDFKB2.jpg")
        val movie2 = PopularMovieJson(id = 342521, title = "Keanu", release_date = "2016-09-14", vote_average = 6.04f, poster_path = "/udU6t5xPNDLlRTxhjXqgWFFYlvO.jpg")
        val movies = listOf(movie1, movie2)

        coEvery { popularMoviesRemoteDataSource.getMovies() } returns movies


        val result = repository.getMovies()

        assert(!result.isNullOrEmpty())
        result?.forEach { movie ->
            assert(movie.image?.startsWith("https://image.tmdb.org/t/p/") == true)
        }
    }

}