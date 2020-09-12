package com.example.stringapp.Model.MobilePost


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NotificationSettings(
    @SerializedName("app_update")
    val appUpdate: Boolean?,
    @SerializedName("comments")
    val comments: Boolean?,
    @SerializedName("contact_joins_string")
    val contactJoinsString: Boolean?,
    @SerializedName("likes")
    val likes: Boolean?,
    @SerializedName("near_you")
    val nearYou: Boolean?,
    @SerializedName("new_followes")
    val newFollowes: Boolean?,
    @SerializedName("post_saves")
    val postSaves: Boolean?,
    @SerializedName("processor")
    val processor: String?,
    @SerializedName("string")
    val string: Boolean?
): Parcelable