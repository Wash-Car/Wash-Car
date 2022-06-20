package com.example.washcar.api.customer.model

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CustomerApi {
    @POST("customer")
    fun createCustomer(@Body customerRequest: CustomerRequest?) : Call<CustomerResponse>
}