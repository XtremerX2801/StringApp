package com.example.stringapp.Model.MobileFeed


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("description")
    val description: String?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("long")
    val long: Double?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("placeID")
    val placeID: String?
)