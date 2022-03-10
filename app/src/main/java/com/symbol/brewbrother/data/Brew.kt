package com.symbol.brewbrother.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.coroutines.delay
import java.io.Serializable
import kotlin.properties.Delegates

@Entity(tableName = "brew_table")
data class Brew(@PrimaryKey @ColumnInfo(name = "Brew_name") var name: String
): Serializable{
    constructor() : this("empty"){

    }

//    @ColumnInfo(name = "Brew_id")
////    @PrimaryKey(autoGenerate = true)
//    var id: Int = 0

}

