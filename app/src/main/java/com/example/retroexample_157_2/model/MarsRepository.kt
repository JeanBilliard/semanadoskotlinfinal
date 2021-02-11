package com.example.retroexample_157_2.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retroexample_157_2.MarsDao
import com.example.retroexample_157_2.model.remote.MarsRealState
import com.example.retroexample_157_2.model.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarsRepository ( private val marsDao: MarsDao) {
    val marsInternet = marsDao.getAllMars()


    private val retrofitClient = RetrofitClient.getRetrofit()


    // Obtener datos con corutinas
    suspend fun fetchDataFromInternetCoroutines()  {
        try {
            val response = retrofitClient.fetchMarsDataCoroutine()
            when(response.code()) {
                in 200..299 -> response.body()?.let { marsDao.insertAllMars(it) }
                in 300..301 -> Log.d("REPO","${response.code()} --- ${response.errorBody()}")
                else -> Log.d("REPO","${response.code()} --- ${response.errorBody().toString()}")
            }
        } catch (t: Throwable) {
            Log.e("REPO", "${t.message}")
        }
    }
 fun getMarsById(id:String):LiveData<MarsRealState>{
     return marsDao.getMarsById(id)
 }
}