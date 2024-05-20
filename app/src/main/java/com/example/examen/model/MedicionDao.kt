package com.example.examen.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicionDao {

    @Query("SELECT * FROM medicion_table ORDER BY id ASC")
    fun getAllMediciones(): Flow<List<MedicionEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(medicion: MedicionEntity)
}
