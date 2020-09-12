package com.example.stringapp.Model.MobilePost


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WanderlustDetails(
    @SerializedName("isWanderlust")
    val isWanderlust: Boolean?,
    @SerializedName("location")
    val location: Location?
): Parcelable