package com.megahed.shoestoreinventory.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.megahed.shoestoreinventory.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {


    private lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentInstructionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

}