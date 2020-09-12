package com.example.stringapp.Model.Like_Save


import com.google.gson.annotations.SerializedName

data class LikeAndSave(
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("data")
    val interactData: Data? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: Boolean? = null
)