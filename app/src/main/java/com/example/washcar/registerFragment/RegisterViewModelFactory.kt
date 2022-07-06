package com.example.washcar.registerFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.washcar.data.LoginDataSource
import com.example.washcar.data.LoginRepository
import com.example.washcar.repository.RemoteRepository
import com.example.washcar.ui.login.LoginViewModel

class RegisterViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(
                remoteRepository= RemoteRepository()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}