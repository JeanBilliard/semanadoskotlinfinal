package com.example.retroexample_157_2.remote

import com.google.gson.annotations.SerializedName

data class MarsRealState(
                    @SerializedName("id")
                    val id: String,
                    @SerializedName("price")
                    val price: Long,
                    @SerializedName("type")
                    val type: String,
                    @SerializedName("img_src")
                    val imgSrc: String)
