package com.example.washcar.cadastrarClienteFragment

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Scroller
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.MotionEventCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.washcar.R
import com.example.washcar.WashCarApplication
import com.example.washcar.api.customer.model.CustomerRequest
import com.example.washcar.databinding.FragmentCadastroClienteBinding
import com.example.washcar.registerFragment.RegisterViewModel

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

        //val customerCreated = CustomerRequest(binding.textFieldNomeCompletoCliente.text.toString(),binding.textInputEditTextEmail.text.toString(),binding.textInputEditTextCpf.text.toString(),binding.textInputEditTextPhoneNumber.text.toString(), binding.textInputEditTextCpf.text.toString())

        binding.button.setOnClickListener {
            //viewmodelCadastroCliente.createCustomer(customerCreated)
            Log.i("customer","${binding.textFieldNomeCompletoCliente.text.toString()}")
        }

        viewmodelCadastroCliente.createCustomerStatus.observe(viewLifecycleOwner, Observer {
            if (it){
                Toast.makeText(requireContext(), "Cliente Cadastrado", Toast.LENGTH_LONG).show()
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
