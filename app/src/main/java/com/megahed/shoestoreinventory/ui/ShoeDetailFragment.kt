package com.megahed.shoestoreinventory.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.megahed.shoestoreinventory.R
import com.megahed.shoestoreinventory.databinding.FragmentShoeDetailBinding
import com.megahed.shoestoreinventory.models.Shoe
import com.megahed.shoestoreinventory.viewModels.MainViewModel

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        val root: View = binding.root

        binding.mainViewModel = mainViewModel
        binding.lifecycleOwner = this
        binding.shoe = Shoe()

        binding.save.setOnClickListener {
            mainViewModel.adShoe(mainViewModel.shoe)
            view?.findNavController()?.navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        binding.cancel.setOnClickListener {
            view?.findNavController()?.navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }


        return root
    }

}