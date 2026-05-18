package com.example.jalsanchay.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RainfallDao {

    @Insert
    suspend fun insertRainfall(rainfall: Rainfall)

    @Query("SELECT * FROM rainfall_table ORDER BY id DESC")
    suspend fun getAllRainfall(): List<Rainfall>

    @Query("SELECT SUM(litersSaved) FROM rainfall_table")
    suspend fun getTotalSaved(): Double?
}