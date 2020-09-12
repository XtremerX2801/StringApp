package com.example.stringapp.ApiService

import com.example.stringapp.Api.ApiRequestHelper
import com.example.stringapp.Model.FollowUser.FollowUser
import com.example.stringapp.Model.Like_Save.LikeAndSave
import com.example.stringapp.Model.MobileFeed.MobileFeed
import com.example.stringapp.Model.MobileFollow.MobileFollow
import com.example.stringapp.Model.MobileInterest.MobileInterest
import com.example.stringapp.Model.Register.MobileRegister
import com.example.stringapp.Model.MobileSignIn.MobileSignIn
import com.example.stringapp.StringApi

class ApiService (private val apiApi: StringApi) {

    fun getRegisterInfo(
        Username: String,
        Name: String,
        DoB: String,
        Email: String,
        Pass: String,
        Con_Pass: String,
        onSuccess : (MobileRegister?) -> Unit,
        onError : (String) -> Unit
    ){
        val request = apiApi.userRegisterEmail(Username, Name, DoB, Email, Pass, Con_Pass)
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getSignInInfo(
        Email: String,
        Pass: String,
        fcm_token: String,
        onSuccess : (MobileSignIn?) -> Unit,
        onError : (String) -> Unit
    ){
        val request = apiApi.userSignInEmail(Email, Pass, fcm_token)
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getInterest(
        Authorization: String,
        onSuccess : (MobileInterest?) -> Unit,
        onError : (String) -> Unit
    ){
        val request = apiApi.userInterest(Authorization)
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getUserList(
        Authorization: String,
        onSuccess : (MobileFollow?) -> Unit,
        onError : (String) -> Unit
    ){
        val request = apiApi.userList(Authorization)
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun sendUserFollowed(
        user_id: Int,
        Authorization: String,
        onSuccess : (FollowUser?) -> Unit,
        onError : (String) -> Unit
    ){
        val request = apiApi.followUser(user_id, Authorization)
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun getMobileFeed(
        page: Int,
        current_per_page: Int,
        Authorization: String,
        onSuccess : (MobileFeed?) -> Unit,
        onError : (String) -> Unit
    ){
        val request = apiApi.getFeed(page, current_per_page, Authorization)
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun setLike(
        id: Int,
        Authorization: String,
        onSuccess : (LikeAndSave?) -> Unit,
        onError : (String) -> Unit
    )
    {
        val request = apiApi.setLike(id, Authorization)
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

    fun savePost(
        id: Int,
        Authorization: String,
        onSuccess : (LikeAndSave?) -> Unit,
        onError : (String) -> Unit
    )
    {
        val request = apiApi.savePost(id, Authorization)
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }

}