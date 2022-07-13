package com.example.washcar.cadastrarCarroFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.washcar.api.car.model.CarRequest
import com.example.washcar.api.car.model.CarResponse
import com.example.washcar.api.carModel.model.CarModelRequest
import com.example.washcar.api.carModel.model.CarModelResponse
import com.example.washcar.api.customer.model.CustomerRequest
import com.example.washcar.api.manufacturer.model.ManufacturerRequest
import com.example.washcar.api.manufacturer.model.ManufacturerResponse
import com.example.washcar.repository.RemoteRepository

class CadastraCarroViewModel(remoteRepository: RemoteRepository) : ViewModel() {

    private var _carRequest = MutableLiveData<CarRequest>()
    val carRequest : LiveData<CarRequest>
        get() = _carRequest

    private var _carResponse = MutableLiveData<CarResponse>()
    val carResponse : LiveData<CarResponse>
        get() = _carResponse

    //-------------------------------------------------------------

    private var _carModelRequest = MutableLiveData<CarModelRequest>()
    val carModelRequest : LiveData<CarModelRequest>
        get() = _carModelRequest

    private var _carModelResponse = MutableLiveData<CarModelResponse>()
    val carModelResponse : LiveData<CarModelResponse>
        get() = _carModelResponse

    //---------------------------------------------------------------

    private var _manufacturerRequest = MutableLiveData<ManufacturerRequest>()
    val manufacturerRequest : LiveData<ManufacturerRequest>
        get() = _manufacturerRequest


    private var _manufacturerResponse = MutableLiveData<ManufacturerResponse>()
    val manufacturerResponse : LiveData<ManufacturerResponse>
        get() = _manufacturerResponse







}