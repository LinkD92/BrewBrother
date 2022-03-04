package com.symbol.brewbrother.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class BrewRepository(private val brewDao: BrewDao) {

    val allBrews: Flow<List<Brew>> = brewDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(brew: Brew){
        brewDao.insert(brew)
    }
    @Suppress
    @WorkerThread
    suspend fun deleteAll(){
        brewDao.deleteAll()
    }

    @Suppress
    @WorkerThread
    suspend fun delete (brew: Brew){
        brewDao.delete(brew)
    }

    @Suppress
    @WorkerThread
    suspend fun update (brew: Brew){
        brewDao.update(brew)
    }
}