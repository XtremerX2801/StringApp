package com.example.stringapp.Model.MobileSignIn

import com.google.gson.annotations.SerializedName

data class MobileSignIn(
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("data")
    val mobileSignInData: Data? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: Boolean? = null
)