package com.example.washcar.api.customer.model

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface CustomerApi {
    @POST("cliente")
    fun createCustomer(@Body customerRequest: CustomerRequest?, @Header("Authorization") authorization: String?) : Call<CustomerResponse>
}