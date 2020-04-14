package com.sanggggg.cocktailor.di

import com.sanggggg.cocktailor.di.annotations.ActivityScope
import com.sanggggg.cocktailor.views.MainActivity
import com.sanggggg.cocktailor.views.detail.DetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity() : MainActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeDetailActivity() : DetailActivity
}