package com.symbol.brewbrother.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Brew::class), version = 1, exportSchema = false)
abstract class BrewDatabase: RoomDatabase() {

    abstract fun brewDao(): BrewDao

    private class BrewDatabaseCallback(
        private val scope: CoroutineScope
    ): RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { brewDatabase ->  scope.launch {
                populateDatabase(brewDatabase.brewDao())
            }}
        }
        suspend fun populateDatabase(brewDao: BrewDao){
            brewDao.deleteAll()
            var brew = Brew("TestBrew")
            brewDao.insert(brew)
    }


    }

    companion object{
        @Volatile
        private var INSTANCE: BrewDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ):BrewDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BrewDatabase::class.java,
                    "brew_database"
                )
                .addCallback(BrewDatabaseCallback(scope))
                    .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                return instance
            }

        }
    }

}