package com.example.stringapp.Model.MobilePost


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoX(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("url")
    val url: UrlX?
): Parcelable