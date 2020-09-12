package com.example.stringapp.Model.MobilePost


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
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
): Parcelable