package com.example.examen_2eva_nicolas_tronchoni.conexion

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examen_2eva_nicolas_tronchoni.dao.Dao
import com.example.examen_2eva_nicolas_tronchoni.modelo.ModeloEj

@Database(entities = [ModeloEj::class], version = 1, exportSchema = false)
abstract class ExamenBaseDatos:RoomDatabase() {
    abstract fun examenDao(): Dao

    companion object {
        @Volatile
        private var Instance: ExamenBaseDatos? = null

        fun obtenerBaseDatos(context: Context): ExamenBaseDatos {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ExamenBaseDatos::class.java, "visitasdb")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}