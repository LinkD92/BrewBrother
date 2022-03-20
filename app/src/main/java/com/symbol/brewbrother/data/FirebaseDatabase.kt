package com.symbol.brewbrother.data


import android.content.Context
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.google.api.LogDescriptor
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.internal.synchronized

class FirebaseDatabase() {
    private val TAG = javaClass.simpleName
    private val database: FirebaseFirestore = FirebaseFirestore.getInstance()
    init {
        database.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
        getAllBrews()
    }
    var allBrews = MutableLiveData<ArrayList<Brew>>()

    companion object {
        @Volatile
        private var INSTANCE: FirebaseDatabase? = null

        fun getDatabase(): FirebaseDatabase {
            return INSTANCE ?: kotlin.synchronized(this) {
                val instance = FirebaseDatabase()
                INSTANCE = instance
                return instance
            }

        }
    }

    fun insert(brew: Brew) {
        val documntId  = database.collection("brews").document()
        brew.id = brew.id ?: documntId.id
        database.collection("brews").document(brew.id.toString()).set(brew)
    }

    fun update(brew: Brew) {
        database.collection("brews").document(brew.id.toString()).set(brew)
    }



    fun getAllBrews(){
        database.collection("brews").addSnapshotListener{
            value, e ->
            if(e != null){
                return@addSnapshotListener
            }
            var list = ArrayList<Brew>()
            val documents = value?.documents
            documents?.forEach{
                val brew = it.toObject(Brew::class.java)
                if(brew != null){
                    list.add(brew!!)
                }
            }
            allBrews.value = list
        }
    }
    


    fun delete(brew: Brew){
        database.collection("brews").document(brew.id.toString()).delete()
    }
}