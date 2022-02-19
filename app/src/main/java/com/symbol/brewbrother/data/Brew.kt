package com.symbol.brewbrother.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.coroutines.delay

@Entity(tableName = "brew_table")
class Brew(var brewName: String)
{
    @PrimaryKey(autoGenerate = true)
    val brewId: Int = 0

}