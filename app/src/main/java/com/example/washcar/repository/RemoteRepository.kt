package com.example.washcar.repository

import com.example.washcar.api.RetrofitInstance
import com.example.washcar.api.carModel.model.CarModelResponse
import com.example.washcar.api.customer.model.CustomerRequest
import com.example.washcar.api.customer.model.CustomerResponse
import com.example.washcar.api.manufacturer.model.ManufacturerResponse
import com.example.washcar.api.user.model.UserRequest
import com.example.washcar.api.user.model.UserResponse
import retrofit2.Call


class RemoteRepository {
   fun createUser(userRequest: UserRequest): Call<UserResponse> {
       return  RetrofitInstance.userApi.createUser(userRequest)
   }

    fun createCustomer(customerRequest: CustomerRequest?, authorization: String?) : Call<CustomerResponse>{
        return RetrofitInstance.customerApi.createCustomer(customerRequest, authorization)
    }

   suspend fun getAllCarModel(authorization: String?) : List<CarModelResponse>{
        return RetrofitInstance.carModelApi.getAllCarModel(authorization)
    }

    suspend fun getCarModelById(authorization: String?, id : Int) : CarModelResponse{
        return RetrofitInstance.carModelApi.getCarModelById(authorization, id)
    }

    suspend fun getAllManufacturer(authorization: String?) : List<ManufacturerResponse> {
        return RetrofitInstance.manufacturerApi.getAllManufacturer(authorization)
    }

    suspend fun getManufacturerById(authorization: String?, id: Int) : ManufacturerResponse{
        return RetrofitInstance.manufacturerApi.getManufacturerById(authorization, id)
    }

}