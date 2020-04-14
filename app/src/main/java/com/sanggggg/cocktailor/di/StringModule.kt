package com.sanggggg.cocktailor.di

import dagger.Module
import dagger.Provides

@Module
class StringModule {
    @Provides
    fun provideInjectSuccessString() : String {
        return "SUCCESS!!"
    }
}