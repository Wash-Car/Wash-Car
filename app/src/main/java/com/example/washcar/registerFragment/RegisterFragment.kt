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
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.washcar.R
import com.example.washcar.WashCarApplication
import com.example.washcar.api.user.model.UserRequest
import com.example.washcar.databinding.FragmentRegisterBinding

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

        val items = listOf("Administrador","Funcionario")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item_funcao, items)
        (binding.textFieldFuncao as? AutoCompleteTextView)?.setAdapter(adapter)









        val factory = RegisterViewModel.Factory((requireActivity().application as WashCarApplication).remoteRepository)

        viewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner




        binding.textFieldRepetirSenha.text


        binding.textButton.setOnClickListener {
            Log.i("response", "${viewModel.userRequest}")
            //viewModel.createUser(viewModel.userRequest)

            Log.i("response", "${binding.textFieldSenha.text}")
            Log.i("response", "${binding.textFieldRepetirSenha.text}")
            var validate : Boolean = true

            var senha = binding.textFieldSenha.text
            var repitirSenha = binding.textFieldRepetirSenha.text
            var email = binding.textFieldEmail.text
            var nome = binding.textFieldNomeCompleto.text
            var funcao = binding.textFieldFuncao.text
            var telefone = binding.textFieldTelefone.text


            if (telefone.toString() == ""){
                binding.outlinedTextFieldTelefone.isErrorEnabled = true
                binding.outlinedTextFieldTelefone.error = "escolha uma função"
                validate = false
            }else{
                binding.outlinedTextFieldTelefone.isErrorEnabled = false
            }

            if (funcao.toString() == ""){
                binding.outlinedTextFieldFuncao.isErrorEnabled = true
                binding.outlinedTextFieldFuncao.error = "escolha uma função"
                validate = false
            }else{
                binding.outlinedTextFieldFuncao.isErrorEnabled = false
            }

            if (nome.toString() == ""){
                binding.outlinedTextFieldNomeCompleto.isErrorEnabled = true
                binding.outlinedTextFieldNomeCompleto.error = "digite um nome"
                validate = false
            }else{
                binding.outlinedTextFieldNomeCompleto.isErrorEnabled = false
            }

            //verificar se eh um email valido
            if (email.toString().contains("@")){
                binding.outlinedTextFieldEmail.isErrorEnabled = false
                Log.i("response", "${email}")
            }else{
                binding.outlinedTextFieldEmail.isErrorEnabled = true
                binding.outlinedTextFieldEmail.error = "email invalido"
                Log.i("response", "${email} invalido")
                validate = false
            }


            if(senha!!.length < 2){
                binding.outlinedTextFieldSenha.isErrorEnabled = true
                binding.outlinedTextFieldSenha.error = "a senha deve ter mais de 5 caracteres"
                validate = false
            }else{
                binding.outlinedTextFieldSenha.isErrorEnabled = false
            }

            //verificar igualdade das senhas
            if (senha.toString() == repitirSenha.toString()){
                binding.outlinedTextFieldRepetirSenha.isErrorEnabled = false
                Log.i("response", "Senhas iguais")
            }else{
                Log.i("response", "Senhas diferentes")
                binding.outlinedTextFieldRepetirSenha.isErrorEnabled = true
                binding.outlinedTextFieldRepetirSenha.error = "as senhas estão diferentes"
                validate = false
            }

            Log.i("response", "validate $validate")
            if(validate){
                Toast.makeText(requireContext(), "usuario cadastrado", Toast.LENGTH_LONG).show()
                viewModel.createUser(viewModel.userRequest)
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment2)
            }else{
                Toast.makeText(requireContext(), "erro ao cadastrar, verifique os campos", Toast.LENGTH_LONG).show()
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
