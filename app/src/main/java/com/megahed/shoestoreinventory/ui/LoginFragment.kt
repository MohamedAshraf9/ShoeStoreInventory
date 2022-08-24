package com.megahed.shoestoreinventory.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.megahed.shoestoreinventory.R
import com.megahed.shoestoreinventory.databinding.FragmentLoginBinding
import com.megahed.shoestoreinventory.viewModels.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        val root: View = binding.root

        binding.loginViewModel = loginViewModel
        binding.lifecycleOwner = this

        binding.login.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        return root
    }

}