package com.sanggggg.cocktailor.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sanggggg.cocktailor.models.Cocktail
import com.sanggggg.cocktailor.models.Ingredient


@Database(entities = [Cocktail::class, Ingredient::class], version = 1, exportSchema = false)
abstract class CocktailorDatabase : RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao
    abstract fun ingredientDao(): IngredientDao

    companion object {
        @Volatile
        private var INSTANCE: CocktailorDatabase? = null

        @JvmStatic
        fun getInstance(context: Context): CocktailorDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                CocktailorDatabase::class.java,
                "cocktail_database"
            ).build().also {
                INSTANCE = it
            }
        }
    }
}