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
import com.github.mainpage.upcomingmovie.adapter.UpcomingMoviesAdapter
import com.github.mainpage.upcomingmovie.viewmodel.UpcomingMoviesState
import com.github.mainpage.upcomingmovie.viewmodel.UpcomingMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainPageFragment : Fragment() {


    private val upcomingViewModel: UpcomingMoviesViewModel by viewModels()
    private lateinit var binding: MainFragmentContentBinding
    private val upcomingMoviesAdapter: UpcomingMoviesAdapter by lazy { UpcomingMoviesAdapter() }


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

        upcomingViewModel.loadUpcomingMovies()
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

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.upcomingRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.upcomingRecyclerView.addItemDecoration(HorizontalItemDecorator(8.dpToPx))
        binding.upcomingRecyclerView.adapter = upcomingMoviesAdapter
    }
}