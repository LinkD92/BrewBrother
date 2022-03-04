package com.symbol.brewbrother.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BrewDao {

    @Query(value = "SELECT * FROM brew_table ORDER BY brew_id ASC")
    fun getAll(): Flow<List<Brew>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(brew: Brew)

    @Query("DELETE FROM brew_table")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(brew: Brew)

    @Update
    suspend fun update(brew: Brew)
}