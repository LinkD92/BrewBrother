package com.symbol.brewbrother.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.symbol.brewbrother.data.Brew
import com.symbol.brewbrother.data.FirebaseDatabase
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class FragEditBrewViewModel(firebaseDatabase: FirebaseDatabase) : BaseViewModel(firebaseDatabase) {

}

class FragEditBrewViewModelFactory(private val firebaseDatabase: FirebaseDatabase): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FragEditBrewViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return FragEditBrewViewModel(firebaseDatabase) as T
        }
        throw IllegalArgumentException("Unknow VM class")
    }

}