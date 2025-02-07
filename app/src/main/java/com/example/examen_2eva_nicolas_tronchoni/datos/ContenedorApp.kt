package com.example.examen_2eva_nicolas_tronchoni.datos

import android.content.Context
import com.example.examen_2eva_nicolas_tronchoni.conexion.ExamenBaseDatos
import com.example.examen_2eva_nicolas_tronchoni.conexion.ServicioApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface ContenedorApp {
    val examenRepositorio: ExamenRepositorio
}

class ExamenContenedorApp(private val context: Context): ContenedorApp {
    private val baseUrl="http://10.0.2.2:3000/"

    private val json= Json {
        ignoreUnknownKeys=true
        coerceInputValues=true
    }

    private val retrofir = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val servicioRetrofit: ServicioApi by lazy {
        retrofir.create(ServicioApi::class.java)
    }

    override val examenRepositorio: ExamenRepositorio by lazy {
        ConexionRepositorio(servicioRetrofit, ExamenBaseDatos.obtenerBaseDatos(context).examenDao())
    }
}
