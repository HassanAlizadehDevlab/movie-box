package com.github.mainpage.popularmovies.adapter

import androidx.constraintlayout.widget.ConstraintLayout
import com.github.mainpage.LayoutWidthChanger
import com.github.mainpage.physicalScreenRectPx
import javax.inject.Inject

class PopularMovie35PercentScreenWidth @Inject constructor(
) : LayoutWidthChanger<ConstraintLayout> {

    override fun change(layout: ConstraintLayout) {
        val lp = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )

        lp.width = (layout.context.physicalScreenRectPx.width() * 0.35).toInt()
        layout.layoutParams = lp
    }
}