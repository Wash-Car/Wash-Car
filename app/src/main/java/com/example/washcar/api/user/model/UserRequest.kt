package com.example.washcar.api.user.model

import com.google.gson.annotations.SerializedName

data class UserRequest (
    @SerializedName("email")
    var email : String,
    @SerializedName("password")
    var password : String,
    @SerializedName("name")
    var name: String?
){
    constructor() :this("", "", "")
}
