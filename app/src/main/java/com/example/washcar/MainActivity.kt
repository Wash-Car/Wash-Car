package com.example.washcar

import android.app.PendingIntent.getActivity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.washcar.cadastrarClienteFragment.CadastroClienteFragmentViewModel
import com.example.washcar.databinding.ActivityMainBinding
import com.example.washcar.databinding.FragmentCadastroClienteBinding
import com.example.washcar.homeFragment.HomeFragmentViewModel
import com.google.android.material.textfield.TextInputLayout

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
        binding.viewmodel = viewModel

        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.fragmentContainerView2.id) as NavHostFragment
        val navController = navHostFragment.navController


//        val imm: InputMethodManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//
//        if (imm.isAcceptingText) {
//
//        } else {
//            binding.bottomNavigationView.visibility = View.VISIBLE
//        }




//        var editText2 =  findViewById<TextInputLayout>(R.id.textInputLayout2)
//        var editText3 =  findViewById<TextInputLayout>(R.id.textInputLayout3)
//        var editText4 =  findViewById<TextInputLayout>(R.id.textInputLayout4)
//        var editText5 =  findViewById<TextInputLayout>(R.id.textInputLayout5)
//        var editText6 =  findViewById<TextInputLayout>(R.id.textInputLayout6)
//        var editText7 =  findViewById<TextInputLayout>(R.id.textInputLayout8)
//        var editText8 =  findViewById<TextInputLayout>(R.id.textInputLayout9)


//
//
//
//
//
//
//
//
//
//        if (
//            editText1.isFocused ||
//            editText2.isFocused ||
//            editText3.isFocused ||
//            editText4.isFocused ||
//            editText5.isFocused ||
//            editText6.isFocused ||
//            editText7.isFocused ||
//            editText8.isFocused
//
//        ){
//         binding.bottomNavigationView.visibility = View.GONE
//
//        }else{
//            binding.bottomNavigationView.visibility = View.VISIBLE
//        }

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