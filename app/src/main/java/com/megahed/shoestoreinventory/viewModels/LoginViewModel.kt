package com.megahed.shoestoreinventory.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val userName = MutableLiveData<String>()
    val password = MutableLiveData<String>()

}