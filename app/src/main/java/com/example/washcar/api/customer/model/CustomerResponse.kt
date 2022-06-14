package com.example.washcar.api.customer.model

import com.google.gson.annotations.SerializedName

data class CustomerResponse(
     @SerializedName("completeName")
     var completeName : String,
     @SerializedName("")
     var email : String,
     @SerializedName("email")
     var cpf : String,
     @SerializedName("phoneNumber")
     var phoneNumber : String,
     @SerializedName("cep")
     var cep : String,
     @SerializedName("id")
     var id : String,
     @SerializedName("createdAt")
     var createdAt : String,
     @SerializedName("updateAt")
     var updateAt : String
 )