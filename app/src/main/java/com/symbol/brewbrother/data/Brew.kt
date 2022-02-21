package com.symbol.brewbrother.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.coroutines.delay
import kotlin.properties.Delegates

@Entity(tableName = "brew_table")
data class Brew(var name: String)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}