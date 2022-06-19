package com.example.washcar.cadastrarClienteFragment

import androidx.lifecycle.*
import com.example.washcar.api.customer.model.CustomerRequest
import com.example.washcar.api.customer.model.CustomerResponse
import com.example.washcar.repository.RemoteRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroClienteFragmentViewModel(remoteRepository: RemoteRepository) : ViewModel() {

    val remoteRepository =  remoteRepository

    private var _customerRequest = MutableLiveData<CustomerRequest>()
    val customerRequest : LiveData<CustomerRequest>
    get() = _customerRequest

    private var _createCustomerStatus = MutableLiveData<Boolean>()
    val createCustomerStatus : LiveData<Boolean>
    get() = _createCustomerStatus

    private var _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    init {
        _customerRequest.value = CustomerRequest()
    }



    fun createCustomer(customerRequest: CustomerRequest?) {
        viewModelScope.launch {
            var request = remoteRepository.createCustomer(customerRequest)
            request.enqueue(object : Callback<CustomerResponse> {
                override fun onResponse(
                    call: Call<CustomerResponse>,
                    response: Response<CustomerResponse>
                ) {
                    if (response.code() == 201){
                        _createCustomerStatus.postValue(true)
                    }else{
                        _createCustomerStatus.postValue(false)
                    }

                }

                override fun onFailure(call: Call<CustomerResponse>, t: Throwable) {
                    _createCustomerStatus.postValue(false)
                    _errorMessage.postValue(t.message)
                }

            })
        }
    }


//    private val _inputIsFocus = MutableLiveData<Boolean>()
//    val inputIsFocus: LiveData<Boolean>
//        get() = _inputIsFocus
//
//
//    fun changeInputIsFocus(){
//        _inputIsFocus.value = true
//    }
//
//    fun resetInputIsFocus(){
//        _inputIsFocus.value = false
//    }

    class Factory (val remoteRepository: RemoteRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CadastroClienteFragmentViewModel::class.java)) {
                return CadastroClienteFragmentViewModel(remoteRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}