package com.example.washcar.cadastrarClienteFragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.washcar.R
import com.example.washcar.databinding.FragmentCadastroClienteBinding

class CadastroClienteFragment : Fragment() {
    lateinit var binding: FragmentCadastroClienteBinding
    lateinit var viewmodelCadastroCliente : CadastroClienteFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_cadastro_cliente,container, false)
        viewmodelCadastroCliente = ViewModelProvider(this).get(CadastroClienteFragmentViewModel::class.java)



        viewmodelCadastroCliente.resetInputIsFocus()


        val imm = requireActivity().applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.isAcceptingText

        //Log.i("fragment", "${imm.isActive}")







//        binding.textFieldNomeCompletoCliente.isTextInputLayoutFocusedRectEnabled = true
//
//
//        viewmodelCadastroCliente.inputIsFocus.observe(viewLifecycleOwner, Observer {
//            if (it){
//
//            }else{
//                if (imm.isAcceptingText){
//                    Log.i("teste", "teclado apareceu")
//                    viewmodelCadastroCliente.changeInputIsFocus()
//                }else{
//                    Log.i("teste", "teclado nao apareceu")
//                }
//            }
//        })
//
//
//
//
//
//        binding.button.setOnClickListener {
//            Log.i("teste", "${imm.isAcceptingText}")
//            viewmodelCadastroCliente.resetInputIsFocus()
//        }
//



        return binding.root
    }

}
