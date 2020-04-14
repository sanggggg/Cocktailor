package com.sanggggg.cocktailor.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sanggggg.cocktailor.di.annotations.ViewModelKey
import com.sanggggg.cocktailor.views.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel) : ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

}