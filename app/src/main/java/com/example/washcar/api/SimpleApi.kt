package com.example.washcar.api

import com.example.washcar.model.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface SimpleApi {
//    @GET("/api/v1/state/")
//    suspend fun getPost() : List<>

    @POST("users/new")
    fun createUser(@Body user: User): Flow<Call<User>>

}
