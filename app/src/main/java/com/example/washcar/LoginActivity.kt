package com.example.washcar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.washcar.databinding.ActivityLoginBinding
import com.example.washcar.ui.login.LoginViewModel
import com.example.washcar.ui.login.LoginViewModelFactory



class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)

        setContentView(binding.root)



        val navHostFragment = (supportFragmentManager.findFragmentById(binding.fragmentContainerView.id)) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupActionBarWithNavController(this,navController)

        //NavigationUI.setupWithNavController(binding.navView, navController, appBarConfiguration)

        //binding.toobar.setupWithNavController(navController, appBarConfiguration)

        loginViewModel.loginStatus.observe(this, Observer {
            if (it){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        })


    }

    override fun onSupportNavigateUp(): Boolean {

        val navController = findNavController(R.id.fragmentContainerView)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    override fun onStart() {
        super.onStart()

    }
}