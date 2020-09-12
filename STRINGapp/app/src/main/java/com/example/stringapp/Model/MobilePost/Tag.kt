package com.example.stringapp.Model.MobilePost


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tag(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?
): Parcelable