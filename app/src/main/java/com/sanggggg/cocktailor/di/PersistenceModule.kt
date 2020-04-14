package com.sanggggg.cocktailor.di

import android.app.Application
import com.sanggggg.cocktailor.local.CocktailDao
import com.sanggggg.cocktailor.local.CocktailorDatabase
import com.sanggggg.cocktailor.local.IngredientDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application) : CocktailorDatabase {
        return CocktailorDatabase.getInstance(application)
    }

    @Singleton
    @Provides
    fun provideCocktailDao(database: CocktailorDatabase) : CocktailDao {
        return database.cocktailDao()
    }

    @Singleton
    @Provides
    fun provideIngredientDao(database: CocktailorDatabase) : IngredientDao {
        return database.ingredientDao()
    }

}
