package com.example.kotlinclass.api

import com.example.kotlinclass.UnsplashAPI
import com.example.kotlinclass.UnsplashItem
import com.example.kotlinclass.UnsplashResult
import com.example.kotlinclass.data.CatItem
import com.example.kotlinclass.data.CatResult
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


private const val BASE_URL = "https://api.api-ninjas.com/"
class CatProvider {
    private val retrofit by lazy {

    val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create<CatApi>()
    }

    fun fetchCats(result: CatResult) {
        retrofit.fetchCat("3").enqueue(object : Callback<List<CatItem>> {
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


