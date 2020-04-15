package com.sanggggg.cocktailor.views.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sanggggg.cocktailor.models.Cocktail
import com.sanggggg.cocktailor.repositories.SearchRepository
import timber.log.Timber
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(repository: SearchRepository) :
    ViewModel() {
    private val _cocktailFirstLetterLiveData = MutableLiveData<String>()
    val cocktailListLiveData: LiveData<List<Cocktail>>

    init {
        Timber.i("MainActivityViewModel injected!")

        cocktailListLiveData = Transformations.switchMap(_cocktailFirstLetterLiveData) { startWith ->
            _cocktailFirstLetterLiveData.value?.let {
                repository.loadCocktailFirstLetter(startWith)
            } ?: object : LiveData<List<Cocktail>>() {
                init {
                    postValue(null)
                }
            }
        }
    }

    fun postCocktailPage(startWith: String) {
        _cocktailFirstLetterLiveData.postValue(startWith)
    }
}