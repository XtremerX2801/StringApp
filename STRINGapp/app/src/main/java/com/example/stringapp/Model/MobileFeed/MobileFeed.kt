package com.example.stringapp.Model.MobileFeed


import com.google.gson.annotations.SerializedName

data class MobileFeed(
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("data")
    val mobileFeedData: List<Data>? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("metadata")
    val metadata: Metadata? = null,
    @SerializedName("status")
    val status: Boolean? = null
)