package com.sanggggg.cocktailor.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sanggggg.cocktailor.models.Cocktail
import com.sanggggg.cocktailor.models.Ingredient

@Dao
interface IngredientDao {
    @Query("SELECT * FROM ingredient WHERE name = :name")
    fun getByName(name: String): LiveData<Ingredient>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIngredients(data: List<Ingredient>)

}