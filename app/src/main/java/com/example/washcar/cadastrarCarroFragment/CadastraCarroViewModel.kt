package com.example.washcar.cadastrarCarroFragment

import androidx.lifecycle.*
import com.example.washcar.api.car.model.CarRequest
import com.example.washcar.api.car.model.CarResponse
import com.example.washcar.api.carModel.model.CarModelRequest
import com.example.washcar.api.carModel.model.CarModelResponse
import com.example.washcar.api.customer.model.CustomerRequest
import com.example.washcar.api.manufacturer.model.ManufacturerRequest
import com.example.washcar.api.manufacturer.model.ManufacturerResponse
import com.example.washcar.repository.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CadastraCarroViewModel(private val remoteRepository: RemoteRepository) : ViewModel() {

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

    private var _listCarModelResponse = MutableLiveData<List<CarModelResponse>>()
    val listCarModelResponse : LiveData<List<CarModelResponse>>
    get() = _listCarModelResponse

    private var _carModelByIdResponse = MutableLiveData<CarModelResponse>()
    val carModelByIdResponse : LiveData<CarModelResponse>
        get() = _carModelByIdResponse

    private var _carModelResponse = MutableLiveData<CarModelResponse>()
    val carModelResponse : LiveData<CarModelResponse>
        get() = _carModelResponse

    //---------------------------------------------------------------

    private var _manufacturerRequest = MutableLiveData<ManufacturerRequest>()
    val manufacturerRequest : LiveData<ManufacturerRequest>
        get() = _manufacturerRequest

    private var _listManufacturerResponse = MutableLiveData<List<ManufacturerResponse>>()
    val listManufacturerResponse : LiveData<List<ManufacturerResponse>>
        get() = _listManufacturerResponse

    private var _manufacturerByIdResponse = MutableLiveData<ManufacturerResponse>()
    val manufacturerByIdResponse : LiveData<ManufacturerResponse>
        get() = _manufacturerByIdResponse


    private var _manufacturerResponse = MutableLiveData<ManufacturerResponse>()
    val manufacturerResponse : LiveData<ManufacturerResponse>
        get() = _manufacturerResponse


    fun getAllCarModel(authorization : String?){
        viewModelScope.launch(Dispatchers.IO) {
            _listCarModelResponse.postValue(remoteRepository.getAllCarModel(authorization))
        }
    }

    fun getCarModelById(authorization : String?, id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            _carModelByIdResponse.postValue(remoteRepository.getCarModelById(authorization, id))
        }
    }

    fun getAllManufacturer(authorization : String?){
        viewModelScope.launch(Dispatchers.IO) {
            _listManufacturerResponse.postValue(remoteRepository.getAllManufacturer(authorization))
            }
        }

    fun getManufacturerById(authorization : String?, id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            _manufacturerByIdResponse.postValue(remoteRepository.getManufacturerById(authorization, id))
        }

    }

    init {

    }








}