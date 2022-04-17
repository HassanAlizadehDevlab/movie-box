package com.github.mainpage.popularmovies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.mainpage.databinding.AdapterItemPopularMovieBinding
import com.github.popular.domain.model.PopularMovie

class PopularMoviesAdapter(
    private val popularMovieWidthChanger: PopularMovieWidthChanger
) : RecyclerView.Adapter<PopularMoviesViewHolder>() {

    private var popularMovies: List<PopularMovie> = listOf()

    fun setPopularMovies(movies: List<PopularMovie>) {
        popularMovies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        val binding = AdapterItemPopularMovieBinding.inflate(LayoutInflater.from(parent.context))

        popularMovieWidthChanger.changeWidth(binding)

        return PopularMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
        val movie = popularMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return popularMovies.size
    }
}