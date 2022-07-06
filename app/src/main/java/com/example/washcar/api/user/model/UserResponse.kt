package com.example.washcar.api.user.model

import com.google.gson.annotations.SerializedName

data class UserResponse(

    @SerializedName("email")
    var email : String,
    @SerializedName("password")
    var password : String,
    @SerializedName("nomeCompleto")
    var name: String?,
//    @SerializedName("completeName")
//    var username: String,
    @SerializedName("telefone")
    var telefone: String,
    @SerializedName("funcao")
    var funcao: String,

    @SerializedName("id")
    var id : String,

    @SerializedName("statusUser")
    var statusUser : Boolean
){
    constructor() :this("", "", "", "", "", "", false)
}