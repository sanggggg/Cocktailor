package com.sanggggg.cocktailor.repositories

import androidx.lifecycle.LiveData
import com.sanggggg.cocktailor.api.CocktailService
import com.sanggggg.cocktailor.local.CocktailDao
import com.sanggggg.cocktailor.models.Cocktail
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val service: CocktailService,
    private val dao: CocktailDao
) {

    fun loadCocktailList(query: String): LiveData<List<Cocktail>> {
        service.fetchCocktailName(query)
            .observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    if (it.isSuccessful) {
                        dao.insertCocktail(it.body()?.drinks ?: listOf())
                    }
                },
                {
                    Timber.e(it)
                }
            )
        return dao.getContains(query)
    }

}