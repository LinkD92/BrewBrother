package com.symbol.brewbrother.data

import java.util.*
import kotlin.collections.ArrayList

data class Brew2(var name:String) {
    //general details
    var date: String? = null
    var remarks: String? = null
    var resources: ArrayList<Resource> = ArrayList()

    //phase 1: brewing

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



    constructor() : this("empty"){

    }

//    @ColumnInfo(name = "Brew_id")
////    @PrimaryKey(autoGenerate = true)
//    var id: Int = 0


    data class Resource(var name: String, var amount: Int){

    }
}