package com.sanggggg.cocktailor.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sanggggg.cocktailor.models.Cocktail

@Dao
interface CocktailDao {
    @Query("SELECT * FROM cocktail WHERE lower(name) LIKE '%' || lower(:name) || '%'")
    fun getContains(name: String): LiveData<List<Cocktail>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCocktail(data: List<Cocktail>)
}