package com.example.stringapp.Model.MobileFeed


import com.google.gson.annotations.SerializedName

data class WorkingHours(
    @SerializedName("FRI")
    val fRI: String?,
    @SerializedName("MON")
    val mON: String?,
    @SerializedName("SAT")
    val sAT: String?,
    @SerializedName("SUN")
    val sUN: String?,
    @SerializedName("THU")
    val tHU: String?,
    @SerializedName("TUE")
    val tUE: String?,
    @SerializedName("WD")
    val wD: String?
)