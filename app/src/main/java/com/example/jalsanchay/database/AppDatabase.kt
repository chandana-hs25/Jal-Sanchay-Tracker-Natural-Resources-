package com.example.jalsanchay.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Rainfall::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun rainfallDao(): RainfallDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "jal_db"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}