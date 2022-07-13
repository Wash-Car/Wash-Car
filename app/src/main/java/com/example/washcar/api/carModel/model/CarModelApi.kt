package com.example.washcar.api.carModel.model

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface CarModelApi {
    @GET("carmodel")
    suspend fun getAllCarModel(@Header("Authorization") authorization: String?) : List<CarModelResponse>

    @GET("carmodel/{id}")
    suspend fun getCarModelById(@Header("Authorization") authorization: String?, @Path("id") id : Int) : CarModelResponse


}