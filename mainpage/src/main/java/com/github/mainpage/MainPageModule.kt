package com.github.mainpage

import com.github.mainpage.upcomingmovie.adapter.UpcomingMovie85PercentScreenWidth
import com.github.mainpage.upcomingmovie.adapter.UpcomingMovieWidthChanger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
abstract class MainPageModule {

    @Binds
    abstract fun bindUpcomingMovieWidthChanger(impl: UpcomingMovie85PercentScreenWidth): UpcomingMovieWidthChanger
}