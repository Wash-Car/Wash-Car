package com.example.washcar.cadastrarCarroFragment

import com.example.washcar.api.carModel.model.CarModelResponse

class CarModelDTO(carModelResponse: CarModelResponse){
    val id = carModelResponse.id
}