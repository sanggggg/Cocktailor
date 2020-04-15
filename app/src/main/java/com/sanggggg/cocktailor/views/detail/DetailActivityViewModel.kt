package com.sanggggg.cocktailor.views.detail

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sanggggg.cocktailor.models.Cocktail
import com.sanggggg.cocktailor.models.Ingredient
import com.sanggggg.cocktailor.repositories.DetailRepository
import javax.inject.Inject

class DetailActivityViewModel @Inject constructor(private val detailRepository: DetailRepository) :
    ViewModel() {

    private val _cocktailLiveData = MutableLiveData<Cocktail>()
    val cocktailLiveData: LiveData<Cocktail>
        get() = _cocktailLiveData

    val recipeLiveData: LiveData<List<Ingredient>>

    val instructionsLiveData: LiveData<List<String>>

    init {
        recipeLiveData = Transformations.switchMap(_cocktailLiveData) {
            detailRepository.loadCocktailWithIngredient(it.ingredients)
        }
        instructionsLiveData = Transformations.map(_cocktailLiveData) {
            it.ingredients.zip(it.measures) { ingredient, measure -> "$ingredient $measure"}
        }
    }

    @MainThread
    fun setModel(cocktail: Cocktail) {
        _cocktailLiveData.value = cocktail
    }
}