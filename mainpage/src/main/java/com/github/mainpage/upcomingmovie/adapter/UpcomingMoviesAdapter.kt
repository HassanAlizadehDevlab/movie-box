package com.github.mainpage.upcomingmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.github.mainpage.databinding.AdapterItemUpcomingMovieBinding
import com.github.mainpage.physicalScreenRectPx
import com.github.upcoming.domain.model.Movie

class UpcomingMoviesAdapter : RecyclerView.Adapter<UpcomingMoviesViewHolder>() {

    private var upcomingMovies: List<Movie> = listOf()

    fun setUpcomingMovies(movies: List<Movie>) {
        upcomingMovies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMoviesViewHolder {
        val binding = AdapterItemUpcomingMovieBinding.inflate(LayoutInflater.from(parent.context))
        binding.root.layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            width = (binding.root.context.physicalScreenRectPx.width() * 0.85).toInt()
        }

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