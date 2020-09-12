package com.example.stringapp.Model.MobileFeed


import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?
)