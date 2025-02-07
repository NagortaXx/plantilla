package com.example.examen_2eva_nicolas_tronchoni.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.examen_2eva_nicolas_tronchoni.Aplicacion
import com.example.examen_2eva_nicolas_tronchoni.datos.ExamenRepositorio
import com.example.examen_2eva_nicolas_tronchoni.modelo.ModeloEj
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface JsonUIState {
    data class ObtenerExitoList(val parques: List<ModeloEj>) : JsonUIState
    data class ObtenerExito(val parque: ModeloEj) : JsonUIState
    data class CrearExito(val parque: ModeloEj) : JsonUIState
    data class ActualizarExito(val parque: ModeloEj) : JsonUIState
    data class EliminarExito(val id: Int) : JsonUIState

    object Error : JsonUIState
    object Cargando : JsonUIState
}

sealed interface BDInternaUIState {
    data class ObtenerExitoList(val visitas: List<ModeloEj>?) : BDInternaUIState
    data class ObtenerExito(val visita: ModeloEj) : BDInternaUIState

    object CrearExito : BDInternaUIState
    object ActualizarExito : BDInternaUIState
    object EliminarExito : BDInternaUIState
    object Error : BDInternaUIState
    object Cargando : BDInternaUIState
}

class ParquesViewModel(private val parquesRepositorio: ExamenRepositorio): ViewModel() {
    //*****INICIO JSONUISTATE*****
    var jsonUIState: JsonUIState by mutableStateOf(JsonUIState.Cargando)
        private set

    var pulsado: ModeloEj by mutableStateOf(ModeloEj())
        private set

    fun actualizarPulsado(parque: ModeloEj){
        pulsado = parque
    }

    fun obtenerJson() {
        viewModelScope.launch {
            jsonUIState = JsonUIState.Cargando
            jsonUIState = try {
                val listaParques:List<ModeloEj> = listOf() //= parquesRepositorio.obtenerParques()
                JsonUIState.ObtenerExitoList(listaParques)
            } catch (e: IOException){
                JsonUIState.Error
            } catch (e: HttpException){
                JsonUIState.Error
            }
        }
    }

    fun obtenerElementoJson(id :Int ) {
        viewModelScope.launch {
            jsonUIState = JsonUIState.Cargando
            jsonUIState = try {
                val parque = ModeloEj()//parquesRepositorio.obtenerParque(id)
                JsonUIState.ObtenerExito(parque)
            } catch (e: IOException){
                JsonUIState.Error
            } catch (e: HttpException){
                JsonUIState.Error
            }
        }
    }

    fun insertarJson(parque: ModeloEj) {
        viewModelScope.launch {
            jsonUIState = JsonUIState.Cargando
            jsonUIState = try {
                val parqueInsertado = ModeloEj()//parquesRepositorio.insertarParque(parque)
                JsonUIState.CrearExito(parqueInsertado)
            } catch (e: IOException){
                JsonUIState.Error
            } catch (e: HttpException){
                JsonUIState.Error
            }
        }
    }

    fun actualizarJson(id: Int, parque: ModeloEj) {
        viewModelScope.launch {
            jsonUIState = JsonUIState.Cargando
            jsonUIState = try {
                val parqueActualizado = ModeloEj()//parquesRepositorio.actualizarParque(
//                    id = id,
//                    parque = parque
//                )
                JsonUIState.ActualizarExito(parqueActualizado)
            } catch (e: IOException){
                JsonUIState.Error
            } catch (e: HttpException){
                JsonUIState.Error
            }
        }
    }

    fun eliminarJson(id: Int) {
        viewModelScope.launch {
            jsonUIState = JsonUIState.Cargando
            jsonUIState = try {
                //parquesRepositorio.eliminarParque(id)
                JsonUIState.EliminarExito(id)
            } catch (e: IOException){
                JsonUIState.Error
            } catch (e: HttpException){
                JsonUIState.Error
            }
        }
    }
    //*****FIN JSONUISTATE*****

    //*****INICIO BDINTERNAUISTATE*****
    var bdInternaUIState: BDInternaUIState by mutableStateOf(BDInternaUIState.Cargando)
        private set

    var pulsada: ModeloEj by mutableStateOf(ModeloEj())
        private set

    fun actualizarPulsadaBDInterna(visita: ModeloEj){
        pulsada = visita
    }

    fun obtenerBDInterna() {
        viewModelScope.launch {
            bdInternaUIState = BDInternaUIState.Cargando
            bdInternaUIState = try {
                val listaVisitas:List<ModeloEj>? = null//parquesRepositorio.obtenerTodasVisitas()
                BDInternaUIState.ObtenerExitoList(listaVisitas)
            } catch (e: IOException){
                BDInternaUIState.Error
            } catch (e: HttpException){
                BDInternaUIState.Error
            } catch (e: Exception) {

                BDInternaUIState.Error
            }
        }
    }

    fun obtenerElementoBDInterna(id :Int ) {
        viewModelScope.launch {
            bdInternaUIState = BDInternaUIState.Cargando
            bdInternaUIState = try {
                val visita = ModeloEj()//parquesRepositorio.obtenerVisita(id)
                BDInternaUIState.ObtenerExito(visita)
            } catch (e: IOException){
                BDInternaUIState.Error
            } catch (e: HttpException){
                BDInternaUIState.Error
            }
        }
    }

    fun insertarBDInterna(visita: ModeloEj) {
        viewModelScope.launch {
            bdInternaUIState = BDInternaUIState.Cargando
            bdInternaUIState = try {
                //parquesRepositorio.insertar(visita)
                BDInternaUIState.CrearExito
            } catch (e: IOException){
                BDInternaUIState.Error
            } catch (e: HttpException){
                BDInternaUIState.Error
            }
        }
    }

    fun actualizarBDInterna(visita: ModeloEj) {
        viewModelScope.launch {
            bdInternaUIState = BDInternaUIState.Cargando
            bdInternaUIState = try {
//                parquesRepositorio.actualizar(
//                    visita = visita
//                )
                BDInternaUIState.ActualizarExito
            } catch (e: IOException){
                BDInternaUIState.Error
            } catch (e: HttpException){
                BDInternaUIState.Error
            }
        }
    }

    fun eliminarBDInterna(visita: ModeloEj) {
        viewModelScope.launch {
            bdInternaUIState = BDInternaUIState.Cargando
            bdInternaUIState = try {
                //parquesRepositorio.eliminar(visita)
                BDInternaUIState.EliminarExito
            } catch (e: IOException){
                BDInternaUIState.Error
            } catch (e: HttpException){
                BDInternaUIState.Error
            }
        }
    }
    //*****FIN BDINTERNAUISTATE*****

    init{
        obtenerJson()
        obtenerBDInterna()
    }

    fun obt() {
        obtenerJson()
        obtenerBDInterna()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val aplicacion = (this[APPLICATION_KEY] as Aplicacion)
                val parquesRepositorio = aplicacion.contenedor.examenRepositorio
                ParquesViewModel(parquesRepositorio = parquesRepositorio)
            }
        }
    }
}