package com.example.washcar.api.user

import androidx.lifecycle.MutableLiveData
import com.example.washcar.api.user.model.UserRequest
import com.example.washcar.api.user.model.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserApi {
    @POST("users")
   suspend fun createUser(@Body userRequest: UserRequest) : Response<UserResponse>
}