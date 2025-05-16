package com.ucb.recuperatorio.Registrar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.ucb.usecase.RegistrarRecordatorio

@HiltViewModel
class RegistrarRecordatorioViewModel @Inject constructor(
    private val registrarRecordatorio: RegistrarRecordatorio
) : ViewModel() {

    fun registrar(nombre: String, fecha: String, importancia: String) {

        viewModelScope.launch {
            registrarRecordatorio(nombre, fecha, importancia)
        }
    }
}