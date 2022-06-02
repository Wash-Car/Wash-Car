package com.example.washcar.registerFragment

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.washcar.R
import com.example.washcar.WashCarApplication
import com.example.washcar.databinding.FragmentRegisterBinding
import com.example.washcar.databinding.HeaderNavigationDrawerBinding
import com.example.washcar.ui.login.SessionManager


class RegisterFragment : Fragment() {

    lateinit var binding: FragmentRegisterBinding

    lateinit var viewModel: RegisterViewModel




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register,container, false)



        var senha = binding.textFieldSenha.text










        val factory = RegisterViewModel.Factory((requireActivity().application as WashCarApplication).remoteRepository)

        viewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner




        binding.textFieldRepetirSenha.text

//        binding.textFieldTelefone.addTextChangedListener(object : TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                TODO("Not yet implemented")
//            }
//
//        })




        binding.textButton.setOnClickListener {
            Log.i("response", "${viewModel.userRequest}")
            //viewModel.createUser(viewModel.userRequest)

            Log.i("response", "${binding.textFieldSenha.text}")
            Log.i("response", "${binding.textFieldRepetirSenha.text}")

            var senha = binding.textFieldSenha.text
            var repitirSenha = binding.textFieldRepetirSenha.text
            var email = binding.textFieldEmail.text


            //verificar se eh um email valido
            if (email.toString().contains("@")){
                Log.i("response", "${email}")
            }else{
                Log.i("response", "${email} invalido")
            }

            //verificar igualdade das senhas
            if (senha.toString() == repitirSenha.toString()){
                Log.i("response", "Senhas iguais")
            }else{
                Log.i("response", "Senhas diferentes")
                Log.i("response", "$senha, $repitirSenha")
            }

        }

//        viewModel.responseCreateUser.observe(viewLifecycleOwner, Observer {
//           if (it.isSuccessful){
//               Log.i("response", "${it.body()}")
//               Log.i("response", "${it.code()}")
//               Log.i("response", "${it.message()}")
//           }
//        })


        return binding.root
    }

}
