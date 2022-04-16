package com.github.mainpage

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalItemDecorator(
    private val spacing: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view) // item position
        val totalItemCount = parent.adapter?.itemCount ?: 0

        val top = spacing
        val bottom = spacing
        val left = if (position == 0) 0 else spacing
        val right = if (position == (totalItemCount - 1)) 0 else spacing

        outRect.set(left, top, right, bottom)
    }
}