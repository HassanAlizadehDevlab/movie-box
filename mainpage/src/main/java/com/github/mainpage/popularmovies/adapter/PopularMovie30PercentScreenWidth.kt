package com.github.mainpage.popularmovies.adapter

import androidx.constraintlayout.widget.ConstraintLayout
import com.github.mainpage.databinding.AdapterItemPopularMovieBinding
import com.github.mainpage.physicalScreenRectPx
import javax.inject.Inject

class PopularMovie30PercentScreenWidth @Inject constructor() : PopularMovieWidthChanger {

    override fun changeWidth(binding: AdapterItemPopularMovieBinding) {
        val lp = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )

        lp.width = (binding.root.context.physicalScreenRectPx.width() * 0.35).toInt()
        binding.root.layoutParams = lp
    }
}