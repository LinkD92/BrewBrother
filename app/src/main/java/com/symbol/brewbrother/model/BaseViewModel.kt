package com.symbol.brewbrother.model

import android.app.usage.UsageEvents
import android.media.metrics.Event
import android.provider.ContactsContract
import android.util.EventLog
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.symbol.brewbrother.data.Brew
import com.symbol.brewbrother.data.BrewRepository
import com.symbol.brewbrother.utility.MyEvent
import com.symbol.brewbrother.utility.NavigationCommand
import kotlinx.coroutines.launch

abstract class BaseViewModel(private val brewRepository: BrewRepository) : ViewModel(){

    val allBrews: LiveData<List<Brew>> = brewRepository.allBrews.asLiveData()

    fun insert(brew: Brew) = viewModelScope.launch {
        brewRepository.insert(brew)
    }

    fun deleteAll() = viewModelScope.launch {
        brewRepository.deleteAll()
    }

    private val _navigation = MutableLiveData<MyEvent<NavigationCommand>>()
    val navigation: LiveData<MyEvent<NavigationCommand>> get() = _navigation

    fun navigate(navDirections: NavDirections) {
        _navigation.value = MyEvent(NavigationCommand.ToDirection(navDirections))
    }

    fun navigateBack() {
        _navigation.value = MyEvent(NavigationCommand.back)
    }


}