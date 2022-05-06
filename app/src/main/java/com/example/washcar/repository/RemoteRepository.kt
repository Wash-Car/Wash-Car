package com.example.washcar.repository

import com.example.washcar.api.RetrofitInstance
import com.example.washcar.api.user.model.UserRequest
import com.example.washcar.api.user.model.UserResponse
import retrofit2.Call
import retrofit2.Response


class RemoteRepository {
    suspend fun createUser(userRequest: UserRequest): Response<UserResponse> {
//
//
            return  RetrofitInstance.userApi.createUser(userRequest)
        }


}