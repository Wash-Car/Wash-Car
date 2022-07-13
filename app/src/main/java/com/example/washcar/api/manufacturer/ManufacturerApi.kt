package com.example.washcar.api.manufacturer

import com.example.washcar.api.manufacturer.model.ManufacturerResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ManufacturerApi {
    @GET("manufacturer")
    suspend fun getAllManufacturer(@Header("Authorization") authorization: String? ) : List<ManufacturerResponse>

    @GET("manufacturer/{id}")
    suspend fun getManufacturerById(@Header("Authorization") authorization: String?, @Path("id") id : Int ) : ManufacturerResponse
}