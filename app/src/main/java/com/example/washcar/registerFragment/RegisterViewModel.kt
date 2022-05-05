package com.example.washcar.registerFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.washcar.model.User

class RegisterViewModel() : ViewModel() {

    val user = MutableLiveData<User>()

}