package com.example.examen.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MedicionViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: MedicionRepository
    val allMediciones: Flow<List<MedicionEntity>>

    init {
        val medicionDao = MedicionDatabase.getDatabase(application).medicionDao()
        repository = MedicionRepository(medicionDao)
        allMediciones = repository.allMediciones
    }

    fun insert(medicion: MedicionEntity) = viewModelScope.launch {
        repository.insert(medicion)
    }
}
