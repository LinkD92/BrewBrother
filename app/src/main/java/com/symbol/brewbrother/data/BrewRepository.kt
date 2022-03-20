package com.symbol.brewbrother.data

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.google.firebase.firestore.FirebaseFirestore

class BrewRepository(private val brewDao: BrewDao) {
//    private val TAG = javaClass.simpleName
//    val allBrews: LiveData<List<Brew>> = brewDao.getAll()
//
//
//    @Suppress("RedundantSuspendModifier")
//    @WorkerThread
//    suspend fun insert(brew: Brew){
//        brewDao.insert(brew)
//
//    }
//    @Suppress
//    @WorkerThread
//    suspend fun deleteAll(){
//        brewDao.deleteAll()
//    }
//
//    @Suppress
//    @WorkerThread
//    suspend fun delete (brew: Brew){
//        brewDao.delete(brew)
//    }
//
//    @Suppress
//    @WorkerThread
//    suspend fun update (brew: Brew){
//        brewDao.update(brew)
//    }
//
//    @Suppress
//    @WorkerThread
//    suspend fun getAsync (){
//        var size = brewDao.getAllSync()
//        Log.d("$TAG - update:", "$size")
//    }

}