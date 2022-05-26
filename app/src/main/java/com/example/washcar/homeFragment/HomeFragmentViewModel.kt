package com.example.washcar.homeFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.washcar.ui.login.SessionManager

class HomeFragmentViewModel(): ViewModel() {
    private val _nome = MutableLiveData<String>()
    val nome: LiveData<String>
    get() = _nome

    private val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email


    init {
        _nome.value = "Filipe"
    }


}