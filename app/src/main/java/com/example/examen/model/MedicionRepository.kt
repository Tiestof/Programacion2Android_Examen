package com.example.examen.model

import kotlinx.coroutines.flow.Flow

class MedicionRepository(private val medicionDao: MedicionDao) {

    val allMediciones: Flow<List<MedicionEntity>> = medicionDao.getAllMediciones()

    suspend fun insert(medicion: MedicionEntity) {
        medicionDao.insert(medicion)
    }
}
