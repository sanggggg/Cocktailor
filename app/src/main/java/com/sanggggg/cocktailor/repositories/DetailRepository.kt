package com.sanggggg.cocktailor.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
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
        val ret = MutableLiveData<List<Ingredient>>()
        val _ret = ArrayList<Ingredient>()


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
                                _ret.addAll(payload.ingredients)
                                ret.postValue(_ret)
                            }
                        }
                    },
                    {
                        Timber.e(it)
                    }
                )
        }
        return ret
    }

}