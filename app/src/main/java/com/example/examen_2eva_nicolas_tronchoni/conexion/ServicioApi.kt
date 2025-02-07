package com.example.examen_2eva_nicolas_tronchoni.conexion

import com.example.examen_2eva_nicolas_tronchoni.modelo.ModeloEj
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ServicioApi {
    @GET("Ejemplo")
    suspend fun obtenerParques(): List<ModeloEj>
//
//    @GET("parques/{id}")
//    suspend fun obtenerParque(@Path("id") id:Int): Parque
//
//    @POST("parques")
//    suspend fun insertarParque( @Body parque: Parque):Parque
//
//    @PUT("parques/{id}")
//    suspend fun actualizarParque(@Path("id") id:Int, @Body parque: Parque): Parque
//
//    @DELETE("parques/{id}")
//    suspend fun eliminarParque(@Path("id") id: Int): Response<Unit>

}