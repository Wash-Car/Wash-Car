package com.example.washcar.api.carModel.model

import com.google.gson.annotations.SerializedName

data class CarModelResponse(
    @SerializedName("id")
    var id : Int,
    @SerializedName("carModel")
    var carModel : String,
    @SerializedName("manufacturerId")
    var manufacturerId : Int
) {
    override fun toString(): String {
        return carModel
    }
}