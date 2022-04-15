package com.github.mainpage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.upcoming.domain.GetUpcomingMoviesUseCase
import com.github.upcoming.domain.UpcomingResult
import com.github.upcoming.domain.model.Movie
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.net.HttpRetryException

class UpcomingMoviesViewModel(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
) : ViewModel() {


    private val _upcomingMovies = MutableStateFlow<UpcomingMoviesState>(UpcomingMoviesState.Nothing)
    val upcomingMovies: StateFlow<UpcomingMoviesState> = _upcomingMovies


    fun loadUpcomingMovies() {
        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            _upcomingMovies.value = UpcomingMoviesState.Error
        }

        viewModelScope.launch(dispatcher + SupervisorJob() + exceptionHandler) {
            val result = getUpcomingMoviesUseCase.execute()
            withContext(Dispatchers.Main) {
                when (result) {
                    is UpcomingResult.Empty -> _upcomingMovies.value = UpcomingMoviesState.Empty
                    is UpcomingResult.Movies -> _upcomingMovies.value = UpcomingMoviesState.Movies(result.movies)
                }
            }
        }
    }

}


sealed class UpcomingMoviesState {
    object Nothing : UpcomingMoviesState()
    object Empty : UpcomingMoviesState()
    object Error : UpcomingMoviesState()
    data class Movies(val movies: List<Movie>) : UpcomingMoviesState()

}