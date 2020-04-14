package com.sanggggg.cocktailor.views

import androidx.lifecycle.ViewModel
import timber.log.Timber
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val message: String) : ViewModel() {
    init {
        Timber.i("I injected $message")
    }


}