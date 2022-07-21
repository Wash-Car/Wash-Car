package com.example.washcar.cadastrarCarroFragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.washcar.R
import com.example.washcar.api.carModel.model.CarModelResponse
import com.example.washcar.databinding.FragmentCadastraCarroBinding


class CadastraCarroFragment : Fragment() {

    lateinit var binding: FragmentCadastraCarroBinding
    lateinit var viewModel: CadastraCarroViewModel
    lateinit var autoCompleteAdapter: AutoCompleteAdapter

    val args: CadastraCarroFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra_carro, container, false)
        viewModel = ViewModelProvider(
            this,
            CadastraCarroViewModelFactory()
        ).get(CadastraCarroViewModel::class.java)
        binding.viewModel = viewModel

        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("washCar", Context.MODE_PRIVATE)
        val accessToken = sharedPreferences.getString("accessToken", "naoVeioToken")

        val listNomeCarModel = mutableListOf<String>()

        viewModel.getAllCarModel(accessToken)
        viewModel.getAllManufacturer(accessToken)


        Toast.makeText(
            requireContext(), "${args.idCliente}", Toast.LENGTH_LONG
        ).show()



        viewModel.listCarModelResponse.observe(viewLifecycleOwner, Observer {
            Log.i("listCarModel", "${viewModel.listCarModelResponse.value}")

            viewModel.listCarModelResponse.value?.forEach {
                Log.i("names", it.carModel)
                listNomeCarModel.add(it.carModel)
            }

            autoCompleteAdapter = AutoCompleteAdapter(
                requireContext(),
                R.layout.list_item_marca,
                it,
                listNomeCarModel
            )
            binding.autoCompleteCarModel.setAdapter(autoCompleteAdapter)

            val onItemClickListener = binding.autoCompleteCarModel.onItemClickListener

            Log.i("carModelId", "$onItemClickListener")


        })

//        binding.autoCompleteCarModel.setOnItemClickListener { adapterView, view, i, l ->
//            val selectCarModel = adapterView.getItemAtPosition(i) as CarModelResponse
//            val carModelId = selectCarModel.id
//
//
//        }

        binding.autoCompleteCarModel.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(
                requireContext(), "${
                    autoCompleteAdapter.getIdItem(
                        i

                    )
                }", Toast.LENGTH_LONG
            ).show()


        })


        //listNomeCarModel.add(viewModel.listCarModelResponse.value)


//        for (i in 0 until viewModel.listCarModelResponse.value!!.size){
//           Log.i("names", viewModel.listCarModelResponse.value?.get(0)!!.carModel)
//        }


//        binding.button2.setOnClickListener {
//            viewModel.getAllCarModel(accessToken)
//            viewModel.getAllManufacturer(accessToken)
//
//            Log.i("listCarModelName", "${viewModel.listCarModelResponse.value?.get(0)!!.carModel} ${listNomeCarModel[0]}" )
//        }


//        // fazer lista com dados vindos da API e fazer um filter na busca
//        val items = listNomeCarModel
//        //val listNomeCarModel =
//        val adapter = ArrayAdapter(requireContext(), R.layout.list_item_marca, items)
//        (binding.autoCompleteCarModel as? AutoCompleteTextView)?.setAdapter(adapter)
////
////        // Inflate the layout for this fragment
        return binding.root
    }


}