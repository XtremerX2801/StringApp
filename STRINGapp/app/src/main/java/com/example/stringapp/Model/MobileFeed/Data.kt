package com.example.stringapp.Model.MobileFeed


import com.example.stringapp.Model.Feed.Itinerary
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("co_edit")
    val coEdit: Boolean?,
    @SerializedName("address")
    val address: String?,
    @SerializedName("coverImage")
    val coverImage: CoverImage?,
    @SerializedName("commentCounter")
    val commentCounter: Int?,
    @SerializedName("copyCounter")
    val copyCounter: Int?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("first_videos")
    val firstVideos: Any?,
    @SerializedName("isPrivate")
    val isPrivate: Boolean?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("isLiked")
    val isLiked: Boolean?,
    @SerializedName("isSaved")
    val isSaved: Boolean?,
    @SerializedName("itineraries")
    val itineraries: List<Itinerary>?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("likeCounter")
    val likeCounter: Int?,
    @SerializedName("long")
    val long: Double?,
    @SerializedName("photos")
    val photos: List<Photo>?,
    @SerializedName("place")
    val place: Place?,
    @SerializedName("placeID")
    val placeID: String?,
    @SerializedName("saveCounter")
    val saveCounter: Int?,
    @SerializedName("strungCounter")
    val strungCounter: Int?,
    @SerializedName("strungFrom")
    val strungFrom: String?,
    @SerializedName("tags")
    val tags: List<Tag>?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("user")
    val user: User?,
    @SerializedName("videos")
    val videos: Any?,
    @SerializedName("walkthrough")
    val walkthrough: Int?,
    @SerializedName("websiteUrl")
    val websiteUrl: String?,
    @SerializedName("workingHours")
    val workingHours: WorkingHours?
)