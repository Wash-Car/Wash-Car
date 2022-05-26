package com.example.washcar.homeFragment

import android.app.FragmentBreadCrumbs
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.washcar.R
import com.example.washcar.databinding.FragmentBlankBinding
import com.example.washcar.databinding.HeaderNavigationDrawerBinding
import com.example.washcar.registerFragment.RegisterViewModel
import com.example.washcar.ui.login.SessionManager


class HomeFragment : Fragment() {

    lateinit var binding: FragmentBlankBinding
    lateinit var bindingHeaderNavigation: HeaderNavigationDrawerBinding
    private lateinit var sessionManager: SessionManager
    lateinit var viewModel: HomeFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank,container, false)
        bindingHeaderNavigation = DataBindingUtil.inflate(inflater, R.layout.header_navigation_drawer,container, false)
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
        binding.viewmodel = viewModel



        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.navigation_drawer, menu)
    }




}