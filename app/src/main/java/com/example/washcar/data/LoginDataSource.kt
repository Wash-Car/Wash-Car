package com.example.washcar.data

import com.example.washcar.api.RetrofitInstance
import com.example.washcar.api.auth.model.LoginRequest
import com.example.washcar.api.auth.model.LoginResponse
import com.example.washcar.data.model.LoggedInUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

//    fun login(username: String, password: String): Result<LoggedInUser> {
//        try {
//            // TODO: handle loggedInUser authentication
//            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), username)
//            return Result.Success(fakeUser)
//        } catch (e: Throwable) {
//            return Result.Error(IOException("Error logging in", e))
//        }
//    }
//   suspend fun login(email: String, password: String): Result<LoginResponse> {
//        val login = LoginRequest(email, password)
//        val response =  RetrofitInstance.authApi.login(login)
//        response.enqueue(object : Callback<LoginResponse>{
//            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//                    if (response.isSuccessful){
//
//                    }else{
//
//                    }
//            }
//
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//        })
//
//    }

    fun logout() {
        // TODO: revoke authentication
    }
}