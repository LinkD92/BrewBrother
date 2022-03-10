package com.symbol.brewbrother.model

import androidx.lifecycle.*
import com.symbol.brewbrother.data.FirebaseDatabase
import java.lang.IllegalArgumentException



class FragBrewListViewModel(firebaseDatabase: FirebaseDatabase) : BaseViewModel(firebaseDatabase) {


}

class FragBrewListViewModelFactory(private val firebaseDatabase: FirebaseDatabase): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FragBrewListViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return FragBrewListViewModel(firebaseDatabase) as T
        }
        throw IllegalArgumentException("Unknow VM class")
    }
}
