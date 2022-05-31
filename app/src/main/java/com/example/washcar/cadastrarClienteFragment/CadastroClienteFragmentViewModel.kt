package com.example.washcar.cadastrarClienteFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CadastroClienteFragmentViewModel : ViewModel() {
    private val _inputIsFocus = MutableLiveData<Boolean>(false)
    val inputIsFocus: LiveData<Boolean>
        get() = _inputIsFocus
}