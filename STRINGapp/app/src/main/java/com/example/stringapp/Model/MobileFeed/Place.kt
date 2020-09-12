package com.example.stringapp.Model.MobileFeed


import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("address")
    val address: String?,
    @SerializedName("copyCounter")
    val copyCounter: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("long")
    val long: Double?,
    @SerializedName("photo")
    val photo: PhotoX?,
    @SerializedName("placeID")
    val placeID: String?,
    @SerializedName("title")
    val title: String?
)