package com.example.retroexample_157_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retroexample_157_2.remote.MarsRealState

class MarsViewModel : ViewModel() {

    private val repository: MarsRepository
    val livedataFromInternet: LiveData<List<MarsRealState>>

    init {
        repository = MarsRepository()
        livedataFromInternet = repository.fetchDataMars()
    }

}