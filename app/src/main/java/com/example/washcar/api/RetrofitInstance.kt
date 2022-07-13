package com.example.washcar.api

import com.example.washcar.api.auth.AuthApi
import com.example.washcar.api.car.CarApi
import com.example.washcar.api.carModel.model.CarModelApi
import com.example.washcar.api.customer.model.CustomerApi
import com.example.washcar.api.manufacturer.ManufacturerApi
import com.example.washcar.api.user.UserApi
import com.example.washcar.data.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.77.15.233:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }

    val userApi: UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }

    val authApi: AuthApi by lazy {
        retrofit.create(AuthApi::class.java)
    }

    val customerApi: CustomerApi by lazy {
        retrofit.create(CustomerApi::class.java)
    }

    val carModelApi: CarModelApi by lazy {
        retrofit.create(CarModelApi::class.java)
    }

    val manufacturerApi: ManufacturerApi by lazy {
        retrofit.create(ManufacturerApi::class.java)
    }

    val car: CarApi by lazy {
        retrofit.create(CarApi::class.java)
    }
}