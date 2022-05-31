package com.github.mainpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mainpage.databinding.MainFragmentContentBinding
import com.github.mainpage.popularmovies.adapter.PopularMovie35PercentScreenWidth
import com.github.mainpage.popularmovies.adapter.PopularMoviesAdapter
import com.github.mainpage.popularmovies.viewmodel.PopularMoviesState
import com.github.mainpage.popularmovies.viewmodel.PopularMoviesViewModel
import com.github.mainpage.upcomingmovie.adapter.UpcomingMovie85PercentScreenWidth
import com.github.mainpage.upcomingmovie.adapter.UpcomingMoviesAdapter
import com.github.mainpage.upcomingmovie.viewmodel.UpcomingMoviesState
import com.github.mainpage.upcomingmovie.viewmodel.UpcomingMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainPageFragment : Fragment() {


    private val upcomingViewModel: UpcomingMoviesViewModel by viewModels()
    private val popularViewModel: PopularMoviesViewModel by viewModels()
    private lateinit var binding: MainFragmentContentBinding
    //
    private val upcomingMoviesAdapter: UpcomingMoviesAdapter by lazy { UpcomingMoviesAdapter(UpcomingMovie85PercentScreenWidth()) }
    private val popularMoviesAdapter: PopularMoviesAdapter by lazy { PopularMoviesAdapter(PopularMovie35PercentScreenWidth()) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        lifecycleScope.launchWhenStarted {
            // observe here
            upcomingViewModel.upcomingMovies.collectLatest { upcomingMovieResponse ->
                println("Hassan: $upcomingMovieResponse")

                when (upcomingMovieResponse) {
                    is UpcomingMoviesState.Movies -> {
                        upcomingMoviesAdapter.setUpcomingMovies(upcomingMovieResponse.movies)
                    }
                    else -> {}
                }
            }
        }

        lifecycleScope.launchWhenStarted {


            popularViewModel.popularMovies.collectLatest { popularMoviesResponse ->
                println("Hassan: $popularMoviesResponse")

                when (popularMoviesResponse) {
                    is PopularMoviesState.Movies -> {
                        popularMoviesAdapter.setPopularMovies(popularMoviesResponse.movies)
                    }
                    else -> {}
                }
            }
        }

        upcomingViewModel.loadUpcomingMovies()
        popularViewModel.loadPopularMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUpcomingRecyclerView()
        setupPopularRecyclerView()
    }

    private fun setupUpcomingRecyclerView() {
        binding.upcomingRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.upcomingRecyclerView.addItemDecoration(HorizontalItemDecorator(8.dpToPx))
        binding.upcomingRecyclerView.adapter = upcomingMoviesAdapter
    }

    private fun setupPopularRecyclerView() {
        binding.popularRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.popularRecyclerView.addItemDecoration(HorizontalItemDecorator(8.dpToPx))
        binding.popularRecyclerView.adapter = popularMoviesAdapter
    }
}