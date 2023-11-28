package com.example.kotlinclass;

public class Interface {
    @Headers({
            "Accept-Version: v1",
            "Authorization: Client-ID YOUR_ACCESS_KEY"
    })
    @GET("photos/{id}")
    Call<UnsplashImage> getPhotoById(@Path("id") String id);
}
