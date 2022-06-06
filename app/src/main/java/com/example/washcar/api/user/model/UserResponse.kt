package com.example.washcar.api.user.model

import com.google.gson.annotations.SerializedName

data class UserResponse(

    @SerializedName("completeName")
    var name : String,

    @SerializedName("email")
    var email : String,

    @SerializedName("phoneNumber")
    var telefone : String,

    @SerializedName("jobFuncion")
    var funcao : String,

    @SerializedName("id")
    var id : String,
){
    constructor() :this("", "", "", "", "")
}