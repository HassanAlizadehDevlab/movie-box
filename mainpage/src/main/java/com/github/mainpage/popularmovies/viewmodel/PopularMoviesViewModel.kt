package com.github.mainpage.popularmovies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.popular.domain.GetPopularMoviesUseCase
import com.github.popular.domain.PopularMoviesResult
import com.github.popular.domain.model.PopularMovie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class PopularMoviesViewModel(
    private val dispatcher: CoroutineDispatcher,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,

    ) : ViewModel() {

    private val _popularMovies = MutableStateFlow<PopularMoviesState>(PopularMoviesState.Nothing)
    val popularMovies: StateFlow<PopularMoviesState> = _popularMovies


    fun loadPopularMovies() {
        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            // TODO remove me, please.
            throw throwable
            _popularMovies.value = PopularMoviesState.Error
        }

        viewModelScope.launch(dispatcher + exceptionHandler) {
            val result = getPopularMoviesUseCase.execute()
            when (result) {
                is PopularMoviesResult.Empty -> _popularMovies.value = PopularMoviesState.Empty
                is PopularMoviesResult.Movies -> {
                    _popularMovies.value = PopularMoviesState.Movies(result.movies)
                }
            }
        }
    }
}

sealed class PopularMoviesState {
    object Nothing : PopularMoviesState()
    object Empty : PopularMoviesState()
    object Error : PopularMoviesState()

    data class Movies(val movies: List<PopularMovie>) : PopularMoviesState()
}
