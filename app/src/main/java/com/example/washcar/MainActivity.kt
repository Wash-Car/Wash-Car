package com.example.washcar

import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.washcar.cadastrarClienteFragment.CadastroClienteFragmentViewModel
import com.example.washcar.databinding.ActivityMainBinding
import com.example.washcar.homeFragment.HomeFragmentViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    //lateinit var bindingCadstroClienteFragment: FragmentCadastroClienteBinding

    lateinit var viewModel: HomeFragmentViewModel
    lateinit var viewmodelCadastroCliente : CadastroClienteFragmentViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //bindingCadstroClienteFragment = DataBindingUtil.setContentView(this, R.layout.fragment_cadastro_cliente)
        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
        viewmodelCadastroCliente = ViewModelProvider(this).get(CadastroClienteFragmentViewModel::class.java)
        binding.viewmodel = viewModel

        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.fragmentContainerView2.id) as NavHostFragment
        val navController = navHostFragment.navController

//
//        val imm = this.applicationContext.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//
//        Log.i("main", "${imm.isActive}")


        viewmodelCadastroCliente.inputIsFocus.observe(this, Observer {
            if (it){
                Log.i("teste", "esconder bottomNavigation")
            }else{
                Log.i("teste", "mostrar bottomNavigation")
            }
        })





            binding.bottomNavigationView.setupWithNavController(navController)


    }
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.fragment)
//        return NavigationUI.navigateUp(navController, binding.drawerLayout)
//    }


}