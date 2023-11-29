package com.example.kotlinclass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

const val AccessKey = "6_dh2gXT-d89ZNUcWdJv12_692dlCElTloNQKCXd5Nk"

interface UnsplashAPI {
    @Headers("Authorization: Client-ID $AccessKey")
    @GET("photos/{id}")
    fun getPhotoById(@Path("id") id:String): Call<UnsplashItem>
}
