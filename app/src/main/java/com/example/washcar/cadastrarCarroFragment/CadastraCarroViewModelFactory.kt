package com.example.washcar.cadastrarCarroFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.washcar.registerFragment.RegisterViewModel
import com.example.washcar.repository.RemoteRepository

class CadastraCarroViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CadastraCarroViewModel::class.java)) {
            return CadastraCarroViewModel(
                remoteRepository= RemoteRepository()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}