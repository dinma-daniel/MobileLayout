package com.example.kotlinclass.api

import com.example.kotlinclass.data.CatItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val ACCESS_KEY = "OwxAp2PdY8lkV+O0stnA/g==fWs8St6zchh1mqVB"

interface CatApi {
    @Headers("X-Api-Key: $ACCESS_KEY")
    @GET("v1/cats/")
    fun fetchCat(@Query(value = "family_friendly") name: String): Call<List<CatItem>>
}