package com.github.mainpage.popularmovies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.popular.domain.GetPopularMoviesUseCase
import com.github.popular.domain.PopularMoviesResult
import com.github.popular.domain.model.PopularMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,

    ) : ViewModel() {

    private val _popularMovies = MutableStateFlow<PopularMoviesState>(PopularMoviesState.Nothing)
    val popularMovies: StateFlow<PopularMoviesState> = _popularMovies.asStateFlow()


    fun loadPopularMovies() {
        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            // TODO remove me, please.
            throw throwable
            _popularMovies.value = PopularMoviesState.Error
        }

        viewModelScope.launch(dispatcher + exceptionHandler) {
            val result = getPopularMoviesUseCase.execute()
            withContext(Dispatchers.Main) {
                when (result) {
                    is PopularMoviesResult.Empty -> _popularMovies.value = PopularMoviesState.Empty
                    is PopularMoviesResult.Movies -> _popularMovies.value =
                        PopularMoviesState.Movies(result.movies)
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
