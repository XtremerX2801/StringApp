package com.example.stringapp.Model.MobileFeed


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("badge")
    val badge: Any?,
    @SerializedName("badgeID")
    val badgeID: Any?,
    @SerializedName("bio")
    val bio: Any?,
    @SerializedName("currentLocation")
    val currentLocation: Any?,
    @SerializedName("date_of_birth")
    val dateOfBirth: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("facebookID")
    val facebookID: Any?,
    @SerializedName("gender")
    val gender: Any?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("isLoginFirst")
    val isLoginFirst: Boolean?,
    @SerializedName("isNewUser")
    val isNewUser: Boolean?,
    @SerializedName("isSuperUser")
    val isSuperUser: Boolean?,
    @SerializedName("name")
    val name: Any?,
    @SerializedName("notificationSettings")
    val notificationSettings: NotificationSettings?,
    @SerializedName("numberOfLogin")
    val numberOfLogin: Int?,
    @SerializedName("profilePhoto")
    val profilePhoto: String?,
    @SerializedName("trash")
    val trash: Boolean?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("wanderlust_details")
    val wanderlustDetails: WanderlustDetails?,
    @SerializedName("website")
    val website: String?
)