package com.example.washcar.registerFragment

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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








        val factory = RegisterViewModel.Factory((requireActivity().application as WashCarApplication).remoteRepository)

        viewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner






        binding.textButton.setOnClickListener {
            Log.i("response", "${viewModel.userRequest}")
            viewModel.createUser(viewModel.userRequest)

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
