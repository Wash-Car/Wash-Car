package com.example.washcar.data.model

data class Lavagem(
    var id: Long,
    var cliente: Cliente,
    var carro: Carro,
    var tipoLavagem: String = "",
    var tipoLavagem2: String = ""
)