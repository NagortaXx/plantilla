package com.example.examen_2eva_nicolas_tronchoni.datos

import com.example.examen_2eva_nicolas_tronchoni.conexion.ServicioApi
import com.example.examen_2eva_nicolas_tronchoni.dao.Dao
import com.example.examen_2eva_nicolas_tronchoni.modelo.ModeloEj
import retrofit2.Response

interface ExamenRepositorio{
    suspend fun obtenerParques(): List<ModeloEj>
//    suspend fun obtenerParque(id:Int): Parque
//    suspend fun insertarParque(parque: Parque):Parque
//    suspend fun actualizarParque(id:Int, parque: Parque): Parque
//    suspend fun eliminarParque(id: Int): Response<Unit>
}

class ConexionRepositorio(private val servicioApi: ServicioApi, private val dao: Dao): ExamenRepositorio {
    override suspend fun obtenerParques(): List<ModeloEj> = servicioApi.obtenerParques()
//    override suspend fun obtenerParque(id :Int): Parque = parquesServicioApi.obtenerParque(id)
//    override suspend fun insertarParque(parque: Parque): Parque=parquesServicioApi.insertarParque(parque)
//    override suspend fun actualizarParque(id: Int, parque: Parque): Parque = parquesServicioApi.actualizarParque(id, parque)
//    override suspend fun eliminarParque(id: Int): Response<Unit> = parquesServicioApi.eliminarParque(id)
}