package com.example.stringapp.Model.MobileFeed


import com.google.gson.annotations.SerializedName

data class PhotoX(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("url")
    val url: UrlX?
)