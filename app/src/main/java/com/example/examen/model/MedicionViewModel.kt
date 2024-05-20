package com.example.examen.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MedicionViewModel : ViewModel() {
    val registros = mutableStateListOf<Medicion>()

    fun addMedicion(medicion: Medicion) {
        registros.add(medicion)
    }
}
