package com.example.washcar.api.user

import androidx.lifecycle.MutableLiveData
import com.example.washcar.model.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("user")
    fun createUser(@Body user: User)
}