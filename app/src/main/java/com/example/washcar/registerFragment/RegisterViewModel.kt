package com.example.washcar.registerFragment

import androidx.lifecycle.*
import com.example.washcar.api.customer.model.CustomerRequest
import com.example.washcar.api.user.model.UserRequest
import com.example.washcar.api.user.model.UserResponse
import com.example.washcar.model.User
import com.example.washcar.repository.RemoteRepository

import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterViewModel(remoteRepository: RemoteRepository) : ViewModel() {

    //var myResponse: MutableLiveData<Call<UserResponse>> = MutableLiveData()
    var status : MutableLiveData<Boolean> = MutableLiveData()
    var errorMessage : MutableLiveData<String> = MutableLiveData()
    var user = User()
    var userRequest = UserRequest()

//    private var _userResponse  = MutableLiveData<UserResponse>()
//    val userResponse : LiveData<UserResponse>
//    get() = _userResponse




//    private var _customerRequest = MutableLiveData<CustomerRequest>()
//    val customerRequest : LiveData<CustomerRequest>
//        get() = _customerRequest


    val remoteRepository =  remoteRepository

    fun createUser(userRequest:UserRequest ){
        viewModelScope.launch {
            val response =   remoteRepository.createUser(userRequest)
            response.enqueue(object : Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.code() == 201){
                        status.postValue(true)
                       //_userResponse.value = response.body()
                    }else{
                        status.postValue(false)
                    }

                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    status.postValue(false)
                    errorMessage.postValue(t.message)
                }

            })
            //myResponse.value = response
        }
    }

//    fun saveUser(id : String, token : String){
//        savedStateHandle["userId"] = id
//        savedStateHandle["userToken"] = token
//    }


}
