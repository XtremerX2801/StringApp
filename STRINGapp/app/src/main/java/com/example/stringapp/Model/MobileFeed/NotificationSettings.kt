package com.example.stringapp.Model.MobileFeed


import com.google.gson.annotations.SerializedName

data class NotificationSettings(
    @SerializedName("app_update")
    val appUpdate: Any?,
    @SerializedName("comments")
    val comments: Any?,
    @SerializedName("contact_joins_string")
    val contactJoinsString: Any?,
    @SerializedName("likes")
    val likes: Any?,
    @SerializedName("near_you")
    val nearYou: Any?,
    @SerializedName("new_followes")
    val newFollowes: Any?,
    @SerializedName("post_saves")
    val postSaves: Any?,
    @SerializedName("processor")
    val processor: String?,
    @SerializedName("string")
    val string: Any?
)