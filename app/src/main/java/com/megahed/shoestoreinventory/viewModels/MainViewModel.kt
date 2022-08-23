package com.megahed.shoestoreinventory.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.megahed.shoestoreinventory.models.Shoe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    private val _shoeData= MutableLiveData<MutableList<Shoe>>()
    val shoeData : LiveData<MutableList<Shoe>> =_shoeData


    init {
        _shoeData.value?.add(Shoe("Originals Vegan Samba", 36.0, "adidas", "Vegan Samba trainers in white"))
        _shoeData.value?.add(Shoe("Nike ZoomX SuperRep Surge", 38.0, "Nike", "Very comfortable"))
        _shoeData.value?.add(Shoe("Originals Vegan Samba1", 39.0, "adidas", "Very comfortable"))
    }

    fun adShoe(shoe: Shoe){
        _shoeData.value?.add(shoe)
    }

}