package com.example.stringapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.stringapp.Model.FollowUser.FollowUser
import com.example.stringapp.Model.Like_Save.LikeAndSave
import com.example.stringapp.Model.MobileFeed.MobileFeed
import com.example.stringapp.Model.MobileFollow.MobileFollow
import com.example.stringapp.Model.MobileInterest.MobileInterest
import com.example.stringapp.Model.MobileSignIn.MobileSignIn
import com.example.stringapp.Model.Register.MobileRegister
import com.example.stringapp.Model.Result

class StringViewModel(private val myRepository: Repository): ViewModel() {

    private val requestRegister = MutableLiveData<Result<MobileRegister>>()
    private var re_username = MutableLiveData<String>()
    private var re_name = MutableLiveData<String>()
    private var re_doB = MutableLiveData<String>()
    private var re_email = MutableLiveData<String>()
    private var re_pass = MutableLiveData<String>()
    private var re_con_pass = MutableLiveData<String>()

    private val requestLogin = MutableLiveData<Result<MobileSignIn>>()

    private val requestInterest = MutableLiveData<Result<MobileInterest>>()

    private val requestUserList = MutableLiveData<Result<MobileFollow>>()
    private val requestUserFollowed = MutableLiveData<Result<FollowUser>>()

    private val requestMobileFeed = MutableLiveData<Result<MobileFeed>>()
    var feedPage = MutableLiveData<Int>()
    var isLoading = MutableLiveData<Boolean>()

    private val requestFeedLike = MutableLiveData<Result<LikeAndSave>>()
    private val requestFeedSave = MutableLiveData<Result<LikeAndSave>>()

    val registerInfo : LiveData<MobileRegister> = Transformations.switchMap(requestRegister){
        it.data
    }

    val loginInfo : LiveData<MobileSignIn> = Transformations.switchMap(requestLogin){
        it.data
    }

    val userInterest = Transformations.switchMap(requestInterest){
        it.data
    }

    val userList = Transformations.switchMap(requestUserList){
        it.data
    }

    val mobileFeed = Transformations.switchMap(requestMobileFeed){
        it.data
    }

    fun getRegisterInfo(Username: String, Name: String, DoB: String, Email: String, Pass: String, Con_Pass: String){
        re_username.value= Username
        re_name.value = Name
        re_doB.value = DoB
        re_email.value = Email
        re_pass.value = Pass
        re_con_pass.value = Con_Pass
        requestRegister.value = myRepository.getRegisterInfo(Username, Name, DoB, Email, Pass, Con_Pass)
    }

    fun getSignInInfo(Email: String, Pass: String, Fcm: String){
        requestLogin.value = myRepository.getSignInInfo(Email, Pass, Fcm)
    }

    fun getInterest(authorization: String){
        requestInterest.value = myRepository.getUserInterest(authorization)
    }

    fun getUserList(authorization: String){
        requestUserList.value = myRepository.getUserList(authorization)
    }

    fun getUserFollowed(user_id: Int, authorization: String){
        requestUserFollowed.value = myRepository.getUserFollowed(user_id, authorization)
    }

    fun getMobileFeed(page: Int, current_per_page: Int, authorization: String){
        feedPage.value = page
        requestMobileFeed.value = myRepository.getMobileFeed(page, current_per_page, authorization)
    }

    fun setLike(id: Int, authorization: String){
        requestFeedLike.value = myRepository.likePost(id, authorization)
    }

    fun savePost(id: Int, authorization: String){
        requestFeedSave.value = myRepository.savePost(id, authorization)
    }
}