package com.example.stringapp.Model.MobilePost


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MobilePost(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val mobilePostData: Data?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: Boolean?
): Parcelable