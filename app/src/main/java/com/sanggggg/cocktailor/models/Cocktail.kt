package com.sanggggg.cocktailor.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "cocktail")
class Cocktail(
    @PrimaryKey @SerializedName("idDrink")
    val id: Long,
    @SerializedName("strDrink")
    val name: String,
    @SerializedName("strTags")
    val tags: String?,
    @SerializedName("strCategory")
    val category: String?,
    @SerializedName("strAlcoholic")
    val alcoholic: String?,
    @SerializedName("strInstructions")
    val instructions: String?,
    @SerializedName("strDrinkThumb")
    val thumbnail: String?,

    val strIngredient1: String? = null, val strMeasure1: String? = null,
    val strIngredient2: String? = null, val strMeasure2: String? = null,
    val strIngredient3: String? = null, val strMeasure3: String? = null,
    val strIngredient4: String? = null, val strMeasure4: String? = null,
    val strIngredient5: String? = null, val strMeasure5: String? = null,
    val strIngredient6: String? = null, val strMeasure6: String? = null,
    val strIngredient7: String? = null, val strMeasure7: String? = null,
    val strIngredient8: String? = null, val strMeasure8: String? = null,
    val strIngredient9: String? = null, val strMeasure9: String? = null


) : Parcelable {

    @IgnoredOnParcel
    @Ignore
    val ingredients: List<String> = listOfNotNull(
        strIngredient1,
        strIngredient2,
        strIngredient3,
        strIngredient4,
        strIngredient5,
        strIngredient6,
        strIngredient7,
        strIngredient8,
        strIngredient9
    )

    @IgnoredOnParcel
    @Ignore
    val measures: List<String> = listOfNotNull(
        strMeasure1,
        strMeasure2,
        strMeasure3,
        strMeasure4,
        strMeasure5,
        strMeasure6,
        strMeasure7,
        strMeasure8,
        strMeasure9
    )

    @Ignore
    @IgnoredOnParcel
    val recipe: List<Pair<String, String>> =
        ingredients.zip(measures) { ingredient, measure -> Pair(ingredient, measure) }

    override fun toString() = "<Cocktail($id): $name>"

    companion object {
        fun testingObj() = Cocktail(1234, "AMF", "tag", "cat", "alco", "do not drink", "asdf")
    }
}