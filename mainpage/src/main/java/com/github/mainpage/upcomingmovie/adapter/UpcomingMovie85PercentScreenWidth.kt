package com.github.mainpage.upcomingmovie.adapter

import androidx.constraintlayout.widget.ConstraintLayout
import com.github.mainpage.databinding.AdapterItemUpcomingMovieBinding
import com.github.mainpage.physicalScreenRectPx
import javax.inject.Inject

class UpcomingMovie85PercentScreenWidth @Inject constructor() : UpcomingMovieWidthChanger {

    override fun changeWidth(binding: AdapterItemUpcomingMovieBinding) {
        val lp = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )

        lp.width = (binding.root.context.physicalScreenRectPx.width() * 0.85).toInt()
        binding.root.layoutParams = lp
    }
}