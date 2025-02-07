package com.example.examen_2eva_nicolas_tronchoni

import android.app.Application
import com.example.examen_2eva_nicolas_tronchoni.datos.ContenedorApp
import com.example.examen_2eva_nicolas_tronchoni.datos.ExamenContenedorApp

class Aplicacion:Application() {
    lateinit var contenedor: ContenedorApp
    override fun onCreate() {
        super.onCreate()
        contenedor = ExamenContenedorApp(this)
    }
}