package com.sanggggg.cocktailor.api

import com.sanggggg.cocktailor.models.Ingredient
import kotlinx.android.parcel.Parcelize

@Parcelize
class IngredientResponse (
    val ingredients: List<Ingredient>
) : NetworkResponse {
    override fun toString() = "$ingredients"
}