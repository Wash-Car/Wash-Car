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
import com.example.washcar.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {

    lateinit var binding: FragmentRegisterBinding
    lateinit var viewModel: RegisterViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register,container, false)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        // Inflate the layout for this fragment


            viewModel.user.observe(viewLifecycleOwner, Observer {
                Toast.makeText(requireContext(), it.email, Toast.LENGTH_SHORT).show()
                Log.i("user", "$it")
            })


        return binding.root
    }

}
