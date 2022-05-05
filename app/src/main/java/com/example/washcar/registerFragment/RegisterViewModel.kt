package com.example.washcar.registerFragment

import androidx.lifecycle.*
import com.example.washcar.model.User
import com.example.washcar.repository.RemoteRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class RegisterViewModel(remoteRepository: RemoteRepository) : ViewModel() {
    lateinit var responseCreateUser: Call<Response<User>>
    val user : User = User()

    val remoteRepository =  remoteRepository

//    fun createUser(user: User){
//        viewModelScope.launch {
//            responseCreateUser = remoteRepository.createUser(user)
//        }
//    }


    class Factory (val remoteRepository: RemoteRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
                return RegisterViewModel(remoteRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}


}

