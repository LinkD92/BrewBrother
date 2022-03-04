package com.symbol.brewbrother.model

import androidx.lifecycle.*
import com.symbol.brewbrother.data.Brew
import com.symbol.brewbrother.data.BrewRepository
import kotlinx.coroutines.launch

abstract class BaseViewModel(private val brewRepository: BrewRepository) : ViewModel(){

    val allBrews: LiveData<List<Brew>> = brewRepository.allBrews.asLiveData()

    fun insert(brew: Brew) = viewModelScope.launch {
        brewRepository.insert(brew)
    }

    fun deleteAll() = viewModelScope.launch {
        brewRepository.deleteAll()
    }

    fun delete(brew: Brew) = viewModelScope.launch {
        brewRepository.delete(brew)
    }

    fun update(brew: Brew) = viewModelScope.launch {
        brewRepository.update(brew)
    }


}