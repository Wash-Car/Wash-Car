package com.example.washcar.registerFragment

import androidx.lifecycle.*
import com.example.washcar.api.user.model.UserRequest
import com.example.washcar.api.user.model.UserResponse
import com.example.washcar.model.User
import com.example.washcar.repository.RemoteRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import retrofit2.Response


class RegisterViewModel(remoteRepository: RemoteRepository) : ViewModel() {

    var myResponse: MutableLiveData<Response<UserResponse>> = MutableLiveData()
    var user = User()
    var userRequest = UserRequest()


    val remoteRepository =  remoteRepository

    fun createUser(userRequest:UserRequest ){
        viewModelScope.launch {
         val response =   remoteRepository.createUser(userRequest)
            myResponse.value = response
        }
    }


    class Factory (val remoteRepository: RemoteRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
                return RegisterViewModel(remoteRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}


}

