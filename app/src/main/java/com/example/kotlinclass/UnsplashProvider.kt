package com.example.kotlinclass

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UnsplashProvider {
    val retrofit by lazy {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(UnsplashAPI::class.java)
    }

    fun getPhotoDetails(result: UnsplashResult, id: String) {
        retrofit.getPhotoById(id).enqueue(object : Callback<UnsplashItem> {
            override fun onResponse(
                call: Call<UnsplashItem>,
                response: Response<UnsplashItem>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    result.onDetailsFetchedSuccess(response.body()!!)
                }
                else{
                    result.onDataFetchedFailed()
                }
            }

            override fun onFailure(call: Call<UnsplashItem>, t: Throwable) {
                result.onDataFetchedFailed()
            }
        })
    }
}