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

}