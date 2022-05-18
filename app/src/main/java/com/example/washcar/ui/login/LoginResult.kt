package com.example.washcar.ui.login

import com.example.washcar.api.auth.model.LoginResponse
import okhttp3.ResponseBody

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
    val success: LoginResponse? = null,
    val error: String = ""
)