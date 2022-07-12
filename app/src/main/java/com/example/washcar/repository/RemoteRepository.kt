package com.example.washcar.repository

import com.example.washcar.api.RetrofitInstance
import com.example.washcar.api.customer.model.CustomerRequest
import com.example.washcar.api.customer.model.CustomerResponse
import com.example.washcar.api.user.model.UserRequest
import com.example.washcar.api.user.model.UserResponse
import retrofit2.Call


class RemoteRepository {
    suspend fun createUser(userRequest: UserRequest): Call<UserResponse> {

            return  RetrofitInstance.userApi.createUser(userRequest)
        }

    fun createCustomer(customerRequest: CustomerRequest?, authorization: String?) : Call<CustomerResponse>{
        return RetrofitInstance.customerApi.createCustomer(customerRequest, authorization)
    }


}