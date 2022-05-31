package com.example.washcar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.washcar.databinding.ActivityMainBinding
import com.example.washcar.databinding.FragmentCadastroClienteBinding
import com.example.washcar.homeFragment.HomeFragmentViewModel
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var bindingCadstroClienteFragment: FragmentCadastroClienteBinding

    lateinit var viewModel: HomeFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bindingCadstroClienteFragment  = DataBindingUtil.setContentView(this, R.layout.fragment_cadastro_cliente)
        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
        binding.viewmodel = viewModel

        val navHostFragment = supportFragmentManager.findFragmentById(binding.fragmentContainerView2.id) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

//        window.decorView.viewTreeObserver.addOnGlobalFocusChangeListener { oldView, newView ->
//            if (newView !is EditText){
//                binding.bottomNavigationView.visibility = View.GONE
//            }
//
//        }


        //melhorar essa parte
//        if (bindingCadstroClienteFragment.textFieldNomeCompletoCliente.isFocusable){
//            binding.bottomNavigationView.visibility = View.GONE
//        }




//
//        var headerView = binding.navigationView.getHeaderView(0)
//
//        var txName = headerView.findViewById<TextView>(R.id.textViewName)
//
//        txName.text = viewModel.nome.value
//
//
//
//
//
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
//        val navController = Navigation.findNavController(this, R.id.fragment)
//        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
           // NavigationUI.setupWithNavController(binding.navigationView, navController)
    }
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.fragment)
//        return NavigationUI.navigateUp(navController, binding.drawerLayout)
//    }


}