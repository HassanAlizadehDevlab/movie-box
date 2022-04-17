package com.github.mainpage.upcomingmovie.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.mainpage.R
import com.github.mainpage.databinding.AdapterItemUpcomingMovieBinding
import com.github.upcoming.domain.model.Movie

class UpcomingMoviesViewHolder(
    private val binding: AdapterItemUpcomingMovieBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {

        binding.title.text = movie.title

        Glide.with(binding.root)
            .load(movie.image)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(binding.image)
    }
}