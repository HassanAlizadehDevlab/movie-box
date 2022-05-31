package com.github.mainpage.upcomingmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.github.mainpage.LayoutWidthChanger
import com.github.mainpage.databinding.AdapterItemUpcomingMovieBinding
import com.github.upcoming.domain.model.UpcomingMovie

class UpcomingMoviesAdapter(
    private val upcomingMovieWidthChanger: LayoutWidthChanger<ConstraintLayout>
) : RecyclerView.Adapter<UpcomingMoviesViewHolder>() {

    private var upcomingMovies: List<UpcomingMovie> = listOf()

    fun setUpcomingMovies(movies: List<UpcomingMovie>) {
        upcomingMovies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMoviesViewHolder {
        val binding = AdapterItemUpcomingMovieBinding.inflate(LayoutInflater.from(parent.context))

        upcomingMovieWidthChanger.change(binding.root)

        return UpcomingMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UpcomingMoviesViewHolder, position: Int) {
        val movie = upcomingMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return upcomingMovies.size
    }
}