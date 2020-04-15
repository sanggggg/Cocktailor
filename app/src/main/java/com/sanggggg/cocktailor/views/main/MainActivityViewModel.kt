package com.sanggggg.cocktailor.views.main

import androidx.annotation.MainThread
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
    private val _cocktailNameLiveData = MutableLiveData<String>()
    val cocktailListLiveData: LiveData<List<Cocktail>>

    init {
        Timber.i("MainActivityViewModel injected!")

        cocktailListLiveData = Transformations.switchMap(_cocktailNameLiveData) { name ->
            _cocktailNameLiveData.value?.let {
                repository.loadCocktailList(name)
            } ?: object : LiveData<List<Cocktail>>() {
                init {
                    postValue(null)
                }
            }
        }
    }

    fun setCocktailName(query: String) {
        _cocktailNameLiveData.postValue(query)
    }
}