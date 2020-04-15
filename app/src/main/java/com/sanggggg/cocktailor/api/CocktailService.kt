package com.sanggggg.cocktailor.api

import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailService {
    @GET("api/json/v1/1/search.php")
    fun fetchCocktailName(@Query("s") name: String): Observable<Response<CocktailResponse>>

    @GET("api/json/v1/1/search.php")
    fun fetchCocktailFirstLetter(@Query("f") letter: String): Observable<Response<CocktailResponse>>

    @GET("api/json/v1/1/lookup.php")
    fun fetchCocktailId(@Query("i") id: Long): Observable<Response<CocktailResponse>>

    @GET("api/json/v1/1/search.php")
    fun fetchIngredientName(@Query("i") name: String): Observable<Response<IngredientResponse>>
}