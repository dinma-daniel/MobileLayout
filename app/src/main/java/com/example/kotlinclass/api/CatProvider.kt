package com.example.kotlinclass.api

import com.example.kotlinclass.UnsplashAPI
import com.example.kotlinclass.UnsplashItem
import com.example.kotlinclass.UnsplashResult
import com.example.kotlinclass.data.CatItem
import com.example.kotlinclass.data.CatResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


private const val BASE_URL = "https://api-ninjas.com/api/cats"
class CatProvider {
    private val retrofit by lazy {
    Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create<CatApi>()
    }

    fun fetchCats(result: CatResult) {
        retrofit.fetchCat().enqueue(object : Callback<List<CatItem>> {
            override fun onResponse(call: Call<List<CatItem>>, response: Response<List<CatItem>>) {
                if (response.isSuccessful && response.body() != null){
                    result.onDataFetchSuccess(response.body()!!)
                }
                else {
                    result.onDataFetchFailed()
                }
            }

            override fun onFailure(call: Call<List<CatItem>>, t: Throwable) {
                result.onDataFetchFailed()
            }

        })
    }
}