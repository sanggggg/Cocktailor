package com.sanggggg.cocktailor.api

import com.sanggggg.cocktailor.models.Cocktail
import kotlinx.android.parcel.Parcelize

@Parcelize
class CocktailResponse(
    val drinks: List<Cocktail> = listOf()
) : NetworkResponse {
    override fun toString(): String = "$drinks"
}
