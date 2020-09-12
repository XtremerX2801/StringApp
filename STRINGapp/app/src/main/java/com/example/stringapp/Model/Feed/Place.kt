package com.example.stringapp.Model.Feed


import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("address")
    val address: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("long")
    val long: Double?,
    @SerializedName("photos")
    val photos: List<PhotoX>?,
    @SerializedName("placeID")
    val placeID: Int?,
    @SerializedName("title")
    val title: String?
)