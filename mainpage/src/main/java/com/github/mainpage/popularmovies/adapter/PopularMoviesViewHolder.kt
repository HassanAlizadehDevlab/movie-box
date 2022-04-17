package com.github.mainpage.popularmovies.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.mainpage.R
import com.github.mainpage.databinding.AdapterItemPopularMovieBinding
import com.github.popular.domain.model.PopularMovie

class PopularMoviesViewHolder(
    private val binding: AdapterItemPopularMovieBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: PopularMovie) {

        binding.title.text = movie.title

        Glide.with(binding.root)
            .load(movie.image)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(binding.image)
    }
}