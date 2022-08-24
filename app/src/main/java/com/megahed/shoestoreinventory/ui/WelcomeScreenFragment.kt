package com.megahed.shoestoreinventory.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.megahed.shoestoreinventory.R
import com.megahed.shoestoreinventory.databinding.FragmentWelcomeScreenBinding

class WelcomeScreenFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_welcome_screen, container, false)
        val root: View = binding.root

        binding.next.setOnClickListener {
            findNavController().navigate(WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToInstructionFragment())
        }

        return root
    }

}