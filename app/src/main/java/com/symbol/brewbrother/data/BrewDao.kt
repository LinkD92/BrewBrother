package com.symbol.brewbrother.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BrewDao {

    @Query(value = "SELECT * FROM brew_table ORDER BY brewId ASC")
    fun getById(): Flow<ArrayList<Brew>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(brew: Brew)

    @Query("DELETE FROM brew_table")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(brew: Brew)
}