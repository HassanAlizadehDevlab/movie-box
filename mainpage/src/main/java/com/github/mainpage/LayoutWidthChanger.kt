package com.github.mainpage

import android.view.ViewGroup

interface LayoutWidthChanger<T : ViewGroup> {
    fun change(layout: T)
}