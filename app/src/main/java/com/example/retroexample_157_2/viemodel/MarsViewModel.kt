package com.example.retroexample_157_2.viemodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retroexample_157_2.model.MarsRepository
import com.example.retroexample_157_2.model.remote.MarsRealState
import kotlinx.coroutines.launch

class MarsViewModel : ViewModel() {

    private val repository: MarsRepository
    val livedataFromInternet: LiveData<List<MarsRealState>>

    init {
        repository = MarsRepository()
        viewModelScope.launch {
            repository.fetchDataFromInternetCoroutines()
        }
        livedataFromInternet = repository.dataFromInternet
    }

}