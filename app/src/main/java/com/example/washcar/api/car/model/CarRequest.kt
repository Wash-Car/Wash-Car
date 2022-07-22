package com.example.washcar.api.car.model

import com.google.gson.annotations.SerializedName

data class CarRequest(
    @SerializedName("anoFabricacao")
    var anoFabricacao : Int,
    @SerializedName("anoModelo")
    var anoModelo : Int,
    @SerializedName("placa")
    var placa : String,
    @SerializedName("carModelId")
    var carModelId : Int,
    @SerializedName("clienteId")
    var clienteId : Int
) {
}