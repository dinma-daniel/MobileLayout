package network

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
class ApiClient {
    private val BASE_URL = "https://api.unsplash.com/"
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}