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

    private fun settings(){

    }


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(brew: Brew) {
        Log.d("$TAG - insert:", "sie wywolal")
        Log.d("$TAG - insert:", "database $database")
        Log.d("$TAG - insert:", "database ${database.app}")
        database.collection("brews").document("${brew.name}").set(brew)
    }

    fun getSingle(brew: Brew): Brew? {
        var brew2: Brew? = null
        database.collection("brews").document(brew.name)
            .get().addOnSuccessListener { snapshot ->
                brew2 = snapshot.toObject<Brew>()!!
            }
        return brew2
    }

    fun contains(brew: Brew): Boolean {
        var exists = false
        database.collection("brews").document(brew.name)
            .get().addOnSuccessListener { snapshot ->
                var brew2 = snapshot.toObject<Brew>()!!
                if (brew == brew2) {
                    exists = true
                }
            }
        return exists
    }


    fun getAllBrews(){
        database.collection("brews").addSnapshotListener{
            value, e ->
            if(e != null){
                Log.d("$TAG - getAll:", "cos sie wysralo")
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
            Log.d("$TAG - getAllBrews:", "${allBrews.value?.size}")
        }
    }
    
    fun getAll(): List<Brew>{
        var list = arrayListOf<Brew>()
        database.collection("brews").get().addOnSuccessListener { documents ->
            for (document in documents){
                Log.d("$TAG - getAllBrews:", "${document.id} a tu data${document.data}")
                var brew = document.toObject<Brew>()
                list.add(brew)
            }
        }
        return list
    }

    fun delete(brew: Brew){

    }
}