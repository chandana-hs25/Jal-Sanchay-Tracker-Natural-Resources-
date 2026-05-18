package com.example.jalsanchay.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rainfall_table")
data class Rainfall(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val rainfall: Double,
    val litersSaved: Double,
    val date: String
)