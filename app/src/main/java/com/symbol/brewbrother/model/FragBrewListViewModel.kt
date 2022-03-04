package com.symbol.brewbrother.model

import androidx.lifecycle.*
import com.symbol.brewbrother.data.BrewRepository
import java.lang.IllegalArgumentException

class FragBrewListViewModel(brewRepository: BrewRepository) : BaseViewModel(brewRepository) {


}

class FragBrewListViewModelFactory(private val brewRepository: BrewRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FragBrewListViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return FragBrewListViewModel(brewRepository) as T
        }
        throw IllegalArgumentException("Unknow VM class")
    }
}
