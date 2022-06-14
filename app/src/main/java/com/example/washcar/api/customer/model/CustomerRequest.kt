package com.example.washcar.api.customer.model

import com.google.gson.annotations.SerializedName

data class CustomerRequest(
    @SerializedName("completeName")
    var completeName : String,
    @SerializedName("email")
    var email : String,
    @SerializedName("cpf")
    var cpf : String,
    @SerializedName("phoneNumber")
    var phoneNumber : String,
    @SerializedName("cep")
    var cep : String
){
    constructor() :this("", "", "", "", "")
}
