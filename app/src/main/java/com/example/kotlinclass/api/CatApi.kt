package com.example.kotlinclass.api

import com.example.kotlinclass.data.CatItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

private const val AUTHORIZATION_CLIENT_ID = "Client-ID"
private const val ACCESS_KEY = "OwxAp2PdY8lkV+O0stnA/g==fWs8St6zchh1mqVB"

interface CatApi {
    @Headers("Authorization: $AUTHORIZATION_CLIENT_ID $ACCESS_KEY")
    @GET("cats")
    fun fetchCat(): Call<List<CatItem>>
}