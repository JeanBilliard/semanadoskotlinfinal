package com.example.retroexample_157_2.viemodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.retroexample_157_2.MarsDataBase
import com.example.retroexample_157_2.model.MarsRepository
import com.example.retroexample_157_2.model.remote.MarsRealState
import kotlinx.coroutines.launch

class MarsViewModel (application: Application) :
    AndroidViewModel(application){

    private val repository: MarsRepository
    val allMars: LiveData<List<MarsRealState>>

    init {
        val marsDao = MarsDataBase.getDataBase(application).getMarsDao()
        repository = MarsRepository(marsDao)
        allMars = repository.marsInternet
        viewModelScope.launch {
            repository.fetchDataFromInternetCoroutines()
        }

    }


}


