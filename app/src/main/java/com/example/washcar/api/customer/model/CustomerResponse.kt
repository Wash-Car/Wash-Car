package com.example.washcar.api.customer.model

import com.google.gson.annotations.SerializedName

data class CustomerResponse(
     @SerializedName("id")
     var id : Int,
     @SerializedName("nomeCompleto")
     var completeName : String,
     @SerializedName("email")
     var email : String,
     @SerializedName("cpf")
     var cpf : String,
     @SerializedName("cep")
     var cep : String,
     @SerializedName("statusCliente")
     var statusCliente : String,

 )