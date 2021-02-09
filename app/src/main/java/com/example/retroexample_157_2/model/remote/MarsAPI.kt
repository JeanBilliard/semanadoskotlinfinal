package com.example.retroexample_157_2.model.remote

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MarsAPI {

    @GET("realestate")
    fun fetchMarsData(): Call<List<MarsRealState>>  // vieja confiable

    @GET("realestate")
    suspend fun fetchMarsDataCoroutine() : Response<List<MarsRealState>> // nueva forma


}