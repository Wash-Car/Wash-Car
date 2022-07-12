package com.example.washcar.api.customer.model

import com.google.gson.annotations.SerializedName

data class CustomerRequest(
    @SerializedName("nomeCompleto")
    var completeName : String = "",
    @SerializedName("email")
    var email : String = "",
    @SerializedName("cpf")
    var cpf : String = "",
    @SerializedName("cep")
    var cep : String = ""
    ){

}
