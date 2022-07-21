package com.example.washcar.cadastrarClienteFragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Scroller
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.washcar.R
import com.example.washcar.WashCarApplication
import com.example.washcar.cadastrarCarroFragment.CadastraCarroFragmentDirections
import com.example.washcar.databinding.FragmentCadastroClienteBinding

class CadastroClienteFragment : Fragment() {
    lateinit var binding: FragmentCadastroClienteBinding
    lateinit var viewmodelCadastroCliente : CadastroClienteFragmentViewModel

    lateinit var scroller : Scroller

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_cadastro_cliente,container, false)




        val factory = CadastroClienteFragmentViewModel.Factory((requireActivity().application as WashCarApplication).remoteRepository)
        viewmodelCadastroCliente = ViewModelProvider(this, factory).get(CadastroClienteFragmentViewModel::class.java)
        binding.viewModel = viewmodelCadastroCliente

        //get values of create customer
        val nomeCompleto : Editable? = binding.textFieldNomeCompletoCliente.text
        val email : Editable? = binding.textInputEditTextEmail.text
        val cpf  : Editable? = binding.textInputEditTextCpf.text
        val phoneNumber  : Editable? =  binding.textInputEditTextPhoneNumber.text
        val cep  : Editable? = binding.textInputEditTextCep.text


        //val customerCreated = CustomerRequest(binding.textFieldNomeCompletoCliente.text.toString(),binding.textInputEditTextEmail.text.toString(),binding.textInputEditTextCpf.text.toString(),binding.textInputEditTextPhoneNumber.text.toString(), binding.textInputEditTextCpf.text.toString())

        val sharedPreferences : SharedPreferences = requireActivity().getSharedPreferences("washCar", Context.MODE_PRIVATE)
        val accessToken = sharedPreferences.getString("accessToken", "naoVeioToken")
        binding.button.setOnClickListener {
            Log.i("tokenCliente", "$accessToken")
            viewmodelCadastroCliente.createCustomer(viewmodelCadastroCliente.customerRequest.value, accessToken)
            Log.i("customer", "${binding.textFieldNomeCompletoCliente.text}, ${nomeCompleto.toString()}, ${binding.textInputEditTextEmail.text}, ${email.toString()}, customer: ${viewmodelCadastroCliente.customerRequest.value!!.email}")
        }

        viewmodelCadastroCliente.createCustomerStatus.observe(viewLifecycleOwner, Observer {
            if (it){
                val customerResponse = viewmodelCadastroCliente.customerResponse.value


                Toast.makeText(requireContext(), "Cliente Cadastrado", Toast.LENGTH_LONG).show()
                viewmodelCadastroCliente.customerId.observe(viewLifecycleOwner, Observer {
                    Toast.makeText(requireContext(), "id do cliente: $id", Toast.LENGTH_LONG).show()
                    //findNavController().navigate(CadastroClienteFragmentDirections.actionCadastroClienteFragmentToCadastraCarroFragment(it))
                })

            }else{
                Toast.makeText(requireContext(), "Erro ao cadastrar o cliente", Toast.LENGTH_LONG).show()
            }
        })





        scroller = Scroller(requireContext())

        val imm = requireActivity().applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        binding.scrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
          imm.hideSoftInputFromWindow(requireView().applicationWindowToken,0)
       }



        return binding.root
    }



}
