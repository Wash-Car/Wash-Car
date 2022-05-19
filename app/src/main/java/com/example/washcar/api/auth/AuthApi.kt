package com.example.washcar.api.auth

import com.example.washcar.api.auth.model.LoginRequest
import com.example.washcar.api.auth.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @POST("login")
     fun login(@Body loginRequest: LoginRequest) : Call<LoginResponse>
}