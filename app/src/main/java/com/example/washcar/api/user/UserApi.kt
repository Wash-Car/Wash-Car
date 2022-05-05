package com.example.washcar.api.user

import com.example.washcar.model.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("user")
    fun createUser(@Body user: User): Flow<Call<User>>
}