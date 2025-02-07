package com.example.examen_2eva_nicolas_tronchoni.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {
//    @Query("SELECT * from Visitas WHERE id = :id")
//    suspend fun obtenerVisita(id: Int): Visita
//
//    @Query("SELECT * from Visitas ORDER BY fecha ASC")
//    suspend fun obtenerTodasVisitas(): List<Visita>?
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insertar(visita: Visita)
//
//    @Update
//    suspend fun actualizar(visita: Visita)
//
//    @Delete()
//    suspend fun eliminar(visita: Visita)
}