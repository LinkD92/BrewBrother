package com.symbol.brewbrother.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.firestore.DocumentReference
import kotlinx.coroutines.delay
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.properties.Delegates

//@Entity(tableName = "brew_table")

//data class Brew(@PrimaryKey @ColumnInfo(name = "Brew_name") var name: String
//): Serializable{
data class Brew(var name: String): Serializable{
    //general details
    var id: String? = null
    private val dataFromat = Calendar.getInstance().time
    private val format = SimpleDateFormat()

    //phase 1: brewing
    var ingredients: ArrayList<Ingredient> = ArrayList()
    var remarks: String? = null
    val date: String = SimpleDateFormat("dd/MM/yyyy").format(dataFromat)

    //phase 2: ferment
    var wortVolume: Double? = null
    var yeastTemperature: Double? = null
    var startingOG: Double? = null
    //

    //phase 3: bottling
    var dateOfBottling: Date? = null
    var fermentResource: String? = null
    var amountOfBottles: Int? = null

    //phase 4: testing



    constructor() : this(""){

    }

//    @ColumnInfo(name = "Brew_id")
////    @PrimaryKey(autoGenerate = true)
//    var id: Int = 0


    data class Ingredient(var name: String, var amount: Int){

        constructor() : this("", 0){

        }
    }

}

