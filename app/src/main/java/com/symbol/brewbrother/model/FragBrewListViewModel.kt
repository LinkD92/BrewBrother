package com.symbol.brewbrother.model

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.NavController
import com.symbol.brewbrother.data.BrewRepository
import com.symbol.brewbrother.utility.FindNavControl
import java.lang.IllegalArgumentException

class FragBrewListViewModel(brewRepository: BrewRepository, fragment: Fragment) : BaseViewModel(brewRepository, fragment) {


}

class FragBrewListViewModelFactory(private val repository: BrewRepository, private val fragment: Fragment): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FragBrewListViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return FragBrewListViewModel(repository, fragment) as T
        }
        throw IllegalArgumentException("Unknow VM class")
    }
}
