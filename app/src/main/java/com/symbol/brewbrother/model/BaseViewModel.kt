package com.symbol.brewbrother.model

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.symbol.brewbrother.R
import com.symbol.brewbrother.data.Brew
import com.symbol.brewbrother.data.BrewRepository
import com.symbol.brewbrother.utility.FindNavControl
import kotlinx.coroutines.launch

abstract class BaseViewModel(private val brewRepository: BrewRepository, val fragment: Fragment) : ViewModel(){

    val allBrews: LiveData<List<Brew>> = brewRepository.allBrews.asLiveData()
    val navController = fragment.findNavController()

    fun insert(brew: Brew) = viewModelScope.launch {
        brewRepository.insert(brew)
    }

    fun deleteAll() = viewModelScope.launch {
        brewRepository.deleteAll()
    }




//
//    private val _navigation = MutableLiveData<MyEvent<NavigationCommand>>()
//    val navigation: LiveData<MyEvent<NavigationCommand>> get() = _navigation
//
//    fun navigate(navDirections: NavDirections) {
//        _navigation.value = MyEvent(NavigationCommand.ToDirection(navDirections))
//    }
//
//    fun navigateBack() {
//        _navigation.value = MyEvent(NavigationCommand.back)
//    }


}