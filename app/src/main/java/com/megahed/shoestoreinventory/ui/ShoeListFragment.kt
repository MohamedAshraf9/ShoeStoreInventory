package com.megahed.shoestoreinventory.ui

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.megahed.shoestoreinventory.R
import com.megahed.shoestoreinventory.databinding.FragmentShoeListBinding
import com.megahed.shoestoreinventory.databinding.ShoeItemBinding
import com.megahed.shoestoreinventory.models.Shoe
import com.megahed.shoestoreinventory.viewModels.MainViewModel


class ShoeListFragment : Fragment(),MenuProvider {

    private lateinit var binding: FragmentShoeListBinding

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        val root: View = binding.root

      /* val shoes= mutableListOf<Shoe>()
       shoes.add(Shoe("Originals Vegan Samba", 36.0, "adidas", "Vegan Samba trainers in white"))
       shoes.add(Shoe("Originals Vegan Samba", 36.0, "adidas", "Vegan Samba trainers in white"))
       shoes.add(Shoe("Originals Vegan Samba", 36.0, "adidas", "Vegan Samba trainers in white"))
        createShoes(shoes)*/
        mainViewModel.getShoeLiveData().observe(viewLifecycleOwner) {
           it?.let {

               createShoes(it)
           }

        }

        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return root
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(menuItem, requireView().findNavController())
    }

    private fun createShoes(shoes: List<Shoe>) {
        context?.let { context ->
            val shoeContainer = binding.list
            shoes.forEach { shoe ->
                displayShoe(shoe)
                val shoeLayout = ShoeLayout(context)
                shoeLayout.loadShoe(shoe)
                shoeContainer.addView(shoeLayout)
            }
        }
    }

    private fun displayShoe(shoe: Shoe) {
        val listItemShoeBinding: ShoeItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.shoe_item, null, false)

        listItemShoeBinding.shoeName.text = shoe.name
        listItemShoeBinding.company.text = shoe.company
        listItemShoeBinding.size.text = shoe.size.toString()
        listItemShoeBinding.description.text =  shoe.description

        binding.list.addView(listItemShoeBinding.root)
    }

}