package com.github.mainpage.popularmovies.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.github.mainpage.upcomingmovie.viewmodel.CoroutineTestRule
import com.github.popular.domain.GetPopularMoviesUseCase
import com.github.popular.domain.PopularMoviesResult
import com.github.popular.domain.model.PopularMovie
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.IOException

@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class PopularMoviesViewModelTest {


    /**
     * InstantTaskExecutorRule comes from the androidx.arch.core:core-testing library.
     * This rule swaps the background executor used by the Architecture Components with a different
     * one which executes each task synchronously.
     */
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineDispatcher = CoroutineTestRule()


    private lateinit var getPopularMoviesUseCase: GetPopularMoviesUseCase
    private lateinit var viewModel: PopularMoviesViewModel


    @Before
    fun setup() {
        getPopularMoviesUseCase = mockk()
        viewModel = PopularMoviesViewModel(
            mainCoroutineDispatcher.testDispatcher,
            getPopularMoviesUseCase
        )
    }

    @After
    fun teardown() {
        unmockkAll()
    }


    @Test
    fun `check the popular movies default state is Nothing`() {
        assert(viewModel.popularMovies.value == PopularMoviesState.Nothing)
    }

    @Test
    fun `when the popular movies result is not empty set the result state with the response in it`() {

        val movies = listOf<PopularMovie>()
        coEvery { getPopularMoviesUseCase.execute() } returns PopularMoviesResult.Movies(movies)

        runTest {
            viewModel.loadPopularMovies()
        }

        coVerify { getPopularMoviesUseCase.execute() }
        assert(viewModel.popularMovies.value == PopularMoviesState.Movies(movies))
    }

    @Test
    fun `when the popular movies result is empty set the empty state`() {

        coEvery { getPopularMoviesUseCase.execute() } returns PopularMoviesResult.Empty

        runTest {
            viewModel.loadPopularMovies()
        }

        assert(viewModel.popularMovies.value == PopularMoviesState.Empty)
    }

    @Test
    fun `when it throws an exception, catch it`() {
        coEvery { getPopularMoviesUseCase.execute() } throws IOException()

        runTest {
            viewModel.loadPopularMovies()
        }

        assert(viewModel.popularMovies.value == PopularMoviesState.Error)
    }

}