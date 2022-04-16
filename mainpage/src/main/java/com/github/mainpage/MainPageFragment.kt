package com.github.mainpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.github.mainpage.databinding.MainFragmentContentBinding
import com.github.mainpage.viewmodel.UpcomingMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainPageFragment : Fragment() {


    private val upcomingViewModel: UpcomingMoviesViewModel by viewModels()
    private lateinit var binding: MainFragmentContentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenStarted {
            // observe here
            upcomingViewModel.upcomingMovies.collectLatest {
                println("Hassan: $it")
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
}