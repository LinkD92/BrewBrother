package com.symbol.brewbrother.model

import android.media.metrics.Event
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import com.symbol.brewbrother.R
import com.symbol.brewbrother.data.Brew
import com.symbol.brewbrother.data.BrewRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class FragBrewListViewModel(private val brewRepository: BrewRepository) : ViewModel() {

    val allBrews: LiveData<List<Brew>> = brewRepository.allBrews.asLiveData()

    fun insert(brew: Brew) = viewModelScope.launch {
        brewRepository.insert(brew)
    }

    fun deleteAll() = viewModelScope.launch {
        brewRepository.deleteAll()
    }



}

class FragBrewListViewModelFactory(private val repository: BrewRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FragBrewListViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return FragBrewListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknow VM class")
    }
}
