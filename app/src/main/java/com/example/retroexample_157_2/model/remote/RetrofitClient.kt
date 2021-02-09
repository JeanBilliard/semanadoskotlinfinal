package com.example.retroexample_157_2.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

        fun getRetrofit(): MarsAPI {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(MarsAPI::class.java)
        }
    }
}