package com.example.washcar.data.model

data class Cliente(
    var nomeCompleto : String = "",
    var endereco: Endereco = Endereco("", "", "", "", "", ""),
    var telefone : String = ""
)
