package com.sanggggg.cocktailor.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sanggggg.cocktailor.api.CocktailService
import com.sanggggg.cocktailor.local.IngredientDao
import com.sanggggg.cocktailor.models.Ingredient
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class DetailRepository @Inject constructor(
    private val service: CocktailService,
    private val dao: IngredientDao
) {
    fun loadCocktailWithIngredient(ingredients: List<String>): LiveData<List<Ingredient>> {
        val recipe = MutableLiveData<List<Ingredient>>()
        val _recipe = ArrayList<Ingredient>()


        // TODO: Room Local DB 에서 읽어오기
        ingredients.forEach { query ->
            service.fetchIngredientName(query)
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        if (it.isSuccessful) {
                            it.body()?.let { payload ->
                                dao.insertIngredients(payload.ingredients)
                                _recipe.addAll(payload.ingredients)
                                recipe.postValue(_recipe)
                            }
                        }
                    },
                    {
                        Timber.e(it)
                    }
                )
        }
        return recipe
    }

}