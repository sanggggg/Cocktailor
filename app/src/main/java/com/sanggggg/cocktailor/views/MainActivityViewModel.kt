package com.sanggggg.cocktailor.views

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sanggggg.cocktailor.models.Cocktail
import com.sanggggg.cocktailor.repositories.SearchRepository
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(repository: SearchRepository) :
    ViewModel() {
    private val _cocktailName = MutableLiveData<String>()
    val cocktailListLiveData: LiveData<List<Cocktail>>

    init {
        cocktailListLiveData =
            Transformations.switchMap(_cocktailName) {
                repository.loadCocktailList(it)
            }
    }

    @MainThread
    fun setCocktailName(query: String) {
        _cocktailName.value = query
    }


}