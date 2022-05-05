package com.example.washcar.registerFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.washcar.R
import com.example.washcar.WashCarApplication
import com.example.washcar.databinding.FragmentRegisterBinding


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





//
//        binding.button.setOnClickListener {
//            viewModel.createUser(viewModel.user)
//
//        }

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
