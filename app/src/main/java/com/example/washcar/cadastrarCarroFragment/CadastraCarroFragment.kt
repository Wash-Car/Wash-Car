package com.example.washcar.cadastrarCarroFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.washcar.R
import com.example.washcar.databinding.FragmentCadastraCarroBinding


class CadastraCarroFragment : Fragment() {

    lateinit var binding: FragmentCadastraCarroBinding
    lateinit var viewModel: CadastraCarroViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra_carro,container, false)
        viewModel = ViewModelProvider(this, CadastraCarroViewModelFactory()).get(CadastraCarroViewModel::class.java)
        binding.viewModel = viewModel


        // fazer lista com dados vindos da API e fazer um filter na busca
        val items = listOf("Fiat", "Hyundai", "Mercedes Benz", "Renault")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item_marca, items)
        (binding.textFieldMarca as? AutoCompleteTextView)?.setAdapter(adapter)

        // Inflate the layout for this fragment
        return binding.root
    }


}