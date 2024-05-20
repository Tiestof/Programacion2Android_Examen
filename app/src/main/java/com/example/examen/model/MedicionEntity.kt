package com.example.examen.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicion_table")
data class MedicionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val medidor: String,
    val fecha: String,
    val tipo: String
)
