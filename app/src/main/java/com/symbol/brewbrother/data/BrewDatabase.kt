package com.symbol.brewbrother.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Brew::class), version = 1, exportSchema = false)
abstract class BrewDatabase: RoomDatabase() {
    abstract fun brewDao(): BrewDao

    companion object{
        private var INSTANCE: BrewDatabase? = null

        fun getDatabase(context: Context):RoomDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BrewDatabase::class.java,
                    "brew_database"
                ).build()
                INSTANCE = instance
                instance
            }

        }
    }

}