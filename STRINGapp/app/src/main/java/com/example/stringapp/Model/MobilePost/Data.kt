package com.example.stringapp.Model.MobilePost


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    @SerializedName("commentCounter")
    val commentCounter: Int?,
    @SerializedName("copyCounter")
    val copyCounter: Int?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("isFeature")
    val isFeature: Int?,
    @SerializedName("isLiked")
    val isLiked: Boolean?,
    @SerializedName("isPrivate")
    val isPrivate: Boolean?,
    @SerializedName("isSaved")
    val isSaved: Boolean?,
    @SerializedName("likeCounter")
    val likeCounter: Int?,
    @SerializedName("photos")
    val photos: List<Photo>?,
    @SerializedName("place")
    val place: Place?,
    @SerializedName("poiID")
    val poiID: Int?,
    @SerializedName("saveCounter")
    val saveCounter: Int?,
    @SerializedName("tags")
    val tags: List<Tag>?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("user")
    val user: User?,
    @SerializedName("userID")
    val userID: Int?,
    @SerializedName("videos")
    val videos: String?
): Parcelable