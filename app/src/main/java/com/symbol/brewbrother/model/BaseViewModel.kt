package com.symbol.brewbrother.model

import androidx.lifecycle.*
import com.symbol.brewbrother.data.Brew
import com.symbol.brewbrother.data.FirebaseDatabase
import kotlinx.coroutines.launch

abstract class BaseViewModel(private val firebaseDatabase: FirebaseDatabase) : ViewModel(){
    private val TAG = javaClass.simpleName

    var allBrews = firebaseDatabase.allBrews


    fun insert(brew: Brew) = viewModelScope.launch {
        firebaseDatabase.insert(brew)
    }

    fun deleteAll() = viewModelScope.launch {
        //brewRepository.deleteAll()
    }

    fun delete(brew: Brew) = viewModelScope.launch {
        //brewRepository.delete(brew)
    }

    fun update(brew: Brew) = viewModelScope.launch {
        //brewRepository.update(brew)
    }


}