package com.github.mainpage.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.github.upcoming.domain.GetUpcomingMoviesUseCase
import com.github.upcoming.domain.UpcomingResult
import com.github.upcoming.domain.model.Movie
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.IOException


@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class UpcomingMoviesViewModelTest {

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

    private lateinit var getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
    private lateinit var viewModel: UpcomingMoviesViewModel

    @Before
    fun setup() {
        getUpcomingMoviesUseCase = mockk()
        viewModel = UpcomingMoviesViewModel(
            mainCoroutineDispatcher.testDispatcher,
            getUpcomingMoviesUseCase
        )
    }

    @After
    fun teardown() {
        unmockkAll()
    }

    @Test
    fun `check the default state is Nothing`() {
        assert(viewModel.upcomingMovies.value is UpcomingMoviesState.Nothing)
    }

    @Test
    fun `when the result is not empty set the result state with the response in it`() {
        runTest {
            val movies = listOf(
                Movie(
                    810693,
                    "The Bad Guys",
                    "2022-03-17",
                    7.8f,
                    "/jrgifaYeUtTnaH7NF5Drkgjg2MB.jpg"
                )
            )
            val response = UpcomingResult.Movies(movies)
            coEvery { getUpcomingMoviesUseCase.execute() } returns response

            viewModel.loadUpcomingMovies()
        }

        coVerify { getUpcomingMoviesUseCase.execute() }
        assert(viewModel.upcomingMovies.value is UpcomingMoviesState.Movies)
    }

    @Test
    fun `when the result is empty set the empty state`() {
        runTest {
            val response = UpcomingResult.Empty
            coEvery { getUpcomingMoviesUseCase.execute() } returns response

            viewModel.loadUpcomingMovies()
        }

        assert(viewModel.upcomingMovies.value is UpcomingMoviesState.Empty)
    }

    @Test
    fun `when it throws an exception, catch it`() {
        runTest {
            coEvery { getUpcomingMoviesUseCase.execute() } throws IOException()
            viewModel.loadUpcomingMovies()
        }

        assert(viewModel.upcomingMovies.value is UpcomingMoviesState.Error)
    }

// Handle errors later
}

// TODO Move me to the right place.
@ExperimentalCoroutinesApi
class CoroutineTestRule(
    val testDispatcher: TestDispatcher = StandardTestDispatcher()
) : TestWatcher() {
    init {
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}