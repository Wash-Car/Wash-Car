package com.example.washcar.cadastrarClienteFragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.washcar.R
import com.example.washcar.databinding.FragmentCadastroClienteBinding

class CadastroClienteFragment : Fragment() {
    lateinit var binding: FragmentCadastroClienteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_cadastro_cliente,container, false)



        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager



        Log.i("teste","${binding.textFieldNomeCompletoCliente.isFocused}")

        var layout =  binding.outlinedTextFieldNomeCompletoCliente
        layout.editText



        binding.textFieldNomeCompletoCliente.setOnClickListener {
            Log.i("teste", "clicou")
            Log.i("teste","${binding.textFieldNomeCompletoCliente.isFocused}")

        }

        binding.button.setOnClickListener {
            Log.i("teste","${binding.textFieldNomeCompletoCliente.isFocused}")
        }




        return binding.root
    }

}
