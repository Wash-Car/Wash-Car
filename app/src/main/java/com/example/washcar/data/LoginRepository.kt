package com.example.washcar.data

import com.example.washcar.api.RetrofitInstance
import com.example.washcar.api.auth.model.LoginRequest
import com.example.washcar.api.auth.model.LoginResponse
import com.example.washcar.data.model.LoggedInUser
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository() {
    private lateinit var result : LoginResponse

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

//    fun logout() {
//        user = null
//        dataSource.logout()
//    }

  suspend fun login(loginRequest: LoginRequest): Call<LoginResponse> {
        // handle login
      return RetrofitInstance.authApi.login(loginRequest)




    }

//    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
//        this.user = loggedInUser
//        // If user credentials will be cached in local storage, it is recommended it be encrypted
//        // @see https://developer.android.com/training/articles/keystore
//    }
}