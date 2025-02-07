package com.example.examen_2eva_nicolas_tronchoni.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName

@Entity
data class ModeloEj (
    @SerialName(value = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int? =0
)