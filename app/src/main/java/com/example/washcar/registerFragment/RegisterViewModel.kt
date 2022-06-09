package com.example.washcar.registerFragment

import androidx.lifecycle.*
import com.example.washcar.api.user.model.UserRequest
import com.example.washcar.api.user.model.UserResponse
import com.example.washcar.model.User
import com.example.washcar.repository.RemoteRepository
import kotlinx.coroutines.launch
import retrofit2.Response


class RegisterViewModel(private val remoteRepository: RemoteRepository) : ViewModel() {

    private var myResponse: MutableLiveData<Response<UserResponse>> = MutableLiveData()
    var user = User()
    var userRequest = UserRequest()


    fun createUser(userRequest:UserRequest ){
        viewModelScope.launch {
         val response =   remoteRepository.createUser(userRequest)
            myResponse.value = response
        }
    }


    class Factory (private val remoteRepository: RemoteRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RegisterViewModel::class.java))
                return RegisterViewModel(remoteRepository) as T
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}


}

