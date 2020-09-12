package com.example.stringapp.Model.Feed


import com.google.gson.annotations.SerializedName

data class Feed(
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("data")
    val feedData: List<Data>? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("metadata")
    val metadata: Metadata? = null,
    @SerializedName("status")
    val status: Boolean? = null
)