package com.example.washcar.api.user.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id")
    var id : Int,

    @SerializedName("email")
    var email : String,

    @SerializedName("name")
    var name : String?
){
    constructor() :this(0, "", "")
}