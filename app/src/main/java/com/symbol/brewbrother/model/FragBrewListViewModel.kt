package com.symbol.brewbrother.model

import android.media.metrics.Event
import android.view.View
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import com.symbol.brewbrother.R
import com.symbol.brewbrother.data.Brew
import com.symbol.brewbrother.data.BrewRepository
import com.symbol.brewbrother.utility.NavigationCommand
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class FragBrewListViewModel(brewRepository: BrewRepository) : BaseViewModel(brewRepository) {

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
