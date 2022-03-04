package com.symbol.brewbrother.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.symbol.brewbrother.data.BrewRepository
import java.lang.IllegalArgumentException

class FragEditBrewViewModel(brewRepository: BrewRepository) : BaseViewModel(brewRepository) {



}

class FragEditBrewViewModelFactory(private val brewRepository: BrewRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FragEditBrewViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return FragEditBrewViewModel(brewRepository) as T
        }
        throw IllegalArgumentException("Unknow VM class")
    }

}