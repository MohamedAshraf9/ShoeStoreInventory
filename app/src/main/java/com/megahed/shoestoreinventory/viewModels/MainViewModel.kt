package com.megahed.shoestoreinventory.viewModels

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.megahed.shoestoreinventory.BR
import com.megahed.shoestoreinventory.models.Shoe

class MainViewModel : ViewModel() , Observable {
    private val propertyChangeRegistry = PropertyChangeRegistry()

    private val _shoeData= MutableLiveData<MutableList<Shoe>>(mutableListOf())
    private val shoeData : LiveData<MutableList<Shoe>> =_shoeData


    init {
        _shoeData.value?.add(Shoe("Originals Vegan Samba", 36.0, "adidas", "Vegan Samba trainers in white"))
        _shoeData.value?.add(Shoe("Nike ZoomX SuperRep Surge", 38.0, "Nike", "Very comfortable"))
        _shoeData.value?.add(Shoe("Originals Vegan Samba1", 39.0, "adidas", "Very comfortable"))
    }

    fun adShoe(shoe: Shoe){
        _shoeData.value?.add(shoe)
    }

    @Bindable
    var shoe = Shoe()
        set(value) {
            if(value != field) {
                field = value
                propertyChangeRegistry.notifyChange(this, BR.shoe_list_item)
            }
        }

    fun getShoeLiveData(): LiveData<MutableList<Shoe>> = shoeData

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }

}