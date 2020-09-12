package com.example.stringapp.Model.MobileFeed


import com.google.gson.annotations.SerializedName

data class CoverImage(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("url")
    val url: Url?
)