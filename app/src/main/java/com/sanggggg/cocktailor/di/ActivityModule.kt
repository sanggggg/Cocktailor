package com.sanggggg.cocktailor.di

import com.sanggggg.cocktailor.di.annotations.ActivityScope
import com.sanggggg.cocktailor.views.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity() : MainActivity
}