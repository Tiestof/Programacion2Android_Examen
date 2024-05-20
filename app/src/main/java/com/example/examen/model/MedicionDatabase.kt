package com.example.examen.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MedicionEntity::class], version = 1)
abstract class MedicionDatabase : RoomDatabase() {
    abstract fun medicionDao(): MedicionDao

    companion object {
        @Volatile
        private var INSTANCE: MedicionDatabase? = null

        fun getDatabase(context: Context): MedicionDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MedicionDatabase::class.java,
                    "medicion_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
