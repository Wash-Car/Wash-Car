package com.example.washcar.api.auth.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("id")
    var id: Int,
    @SerializedName("access_token")
    var accessToken : String
)
