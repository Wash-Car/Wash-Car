package com.example.washcar.homeFragment

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.washcar.data.model.Carro
import com.example.washcar.data.model.Cliente
import com.example.washcar.data.model.Endereco
import com.example.washcar.data.model.Lavagem
import com.example.washcar.repository.RemoteRepository


class HomeFragmentViewModel(): ViewModel() {



    private val _nome = MutableLiveData<String>()
    val nome: LiveData<String>
    get() = _nome

    private val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email

    private val _listLavagem : MutableLiveData<List<Lavagem>> = MutableLiveData()
    val listLavagem: LiveData<List<Lavagem>>
    get() = _listLavagem

    // ajeitar dps
//    fun getListLavagens(){
//        val lista : List<Lavagem> = listOf(Lavagem(1, cliente = Cliente("filipe", endereco = Endereco("rua a","centro", "31", "59200-000", "santa Cruz", "RN"), "999999" ), carro = Carro("fiat", "toro",2020,2020,"aaa-000", "hatch"), "pequena", "polimento"))
//        _listLavagem.value = lista
//
//    }


    init {
        _nome.value = "Filipe"
    }


}