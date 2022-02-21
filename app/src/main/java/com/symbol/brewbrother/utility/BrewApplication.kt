package com.symbol.brewbrother.utility

import android.app.Application
import com.symbol.brewbrother.data.BrewDatabase
import com.symbol.brewbrother.data.BrewRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class BrewApplication: Application() {

    val appScope = CoroutineScope(SupervisorJob())
    val database by lazy { BrewDatabase.getDatabase(this, appScope)  }
    val repository by lazy { BrewRepository(database.brewDao()) }

}