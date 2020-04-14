package com.sanggggg.cocktailor.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
class Ingredient (
    @PrimaryKey
    @SerializedName("idIngredient")
    val id: Long,
    @SerializedName("strIngredient")
    val name: String,
    @SerializedName("strType")
    val type: String?,
    @SerializedName("strAlcohol")
    val alcohol: String?,
    @SerializedName("strABV")
    val abv: Long?
) : Parcelable {
    override fun toString() = "<Ingredient($id): $name>"
}