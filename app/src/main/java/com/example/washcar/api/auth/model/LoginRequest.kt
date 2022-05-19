package com.example.washcar.api.auth.model

data class LoginRequest(
    var email : String,
    var password : String
) {
}