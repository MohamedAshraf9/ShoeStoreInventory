package com.megahed.shoestoreinventory.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.megahed.shoestoreinventory.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.login.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        return root
    }

}