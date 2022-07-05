package com.example.washcar.ui.login

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.*
import com.example.washcar.data.LoginRepository

import com.example.washcar.R
import com.example.washcar.api.auth.model.LoginRequest
import com.example.washcar.api.auth.model.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor (private val loginRepository: LoginRepository, private val state: SavedStateHandle) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    private val _loginStatus = MutableLiveData<Boolean>()
    val loginStatus: LiveData<Boolean> = _loginStatus


    val userToken : LiveData<String> =
        state.getLiveData("userToken")

    fun setStatusFalse(){
        _loginStatus.value = false
    }

    fun login(email: String, password: String)  {
       viewModelScope.launch {

           val login = LoginRequest(email,password)
           val response = loginRepository.login(login)
           //_loginStatus.value = true
           response.enqueue(object : Callback<LoginResponse>{

               override fun onResponse(
                   call: Call<LoginResponse>,
                   response: Response<LoginResponse>
               ) {
                   if (response.code() == 201){
                       _loginStatus.value = true
                       Log.i("responses", "${response.code()}")
                       Log.i("responses", "${_loginStatus.value}")
                       _loginResult.value =
                           LoginResult(success = response.body())
                           saveUserLogged(response.body())

                   }else if(response.code() == 401){
                       _loginStatus.value = false
                       Log.i("responses", "${response.code()}")
                       Log.i("responses", "${_loginStatus.value}")
                       _loginResult.value = LoginResult(error = "Email e/ou senha incorretos")

                   }

               }


               override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

               }

           })



       }

    }

    fun saveUserLogged(loginResponse: LoginResponse?){
        if (loginResponse != null) {
            state["userToken"] = loginResponse.accessToken
        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains("@")) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}