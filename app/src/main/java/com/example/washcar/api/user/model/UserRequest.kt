package com.example.washcar.api.user.model

import com.google.gson.annotations.SerializedName

data class UserRequest (
    @SerializedName("email")
    var email : String,
    @SerializedName("password")
    var password : String,
    @SerializedName("completeName")
    var name: String?,
//    @SerializedName("completeName")
//    var username: String,
    @SerializedName("phoneNumber")
    var telefone: String,
    @SerializedName("jobFuncion")
    var funcao: String
){
    constructor() :this("", "", "", "", "")
}
