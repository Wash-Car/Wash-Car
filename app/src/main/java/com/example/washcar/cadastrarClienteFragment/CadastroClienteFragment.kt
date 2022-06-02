package com.example.washcar.cadastrarClienteFragment

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Scroller
import androidx.core.view.MotionEventCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.washcar.R
import com.example.washcar.databinding.FragmentCadastroClienteBinding

class CadastroClienteFragment : Fragment() {
    lateinit var binding: FragmentCadastroClienteBinding
    lateinit var viewmodelCadastroCliente : CadastroClienteFragmentViewModel

    lateinit var scroller : Scroller

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_cadastro_cliente,container, false)
        viewmodelCadastroCliente = ViewModelProvider(this).get(CadastroClienteFragmentViewModel::class.java)



        scroller = Scroller(requireContext())

        val imm = requireActivity().applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        binding.scrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
          imm.hideSoftInputFromWindow(requireView().applicationWindowToken,0)
       }

        return binding.root
    }



}
