package com.ucb.recuperatorio.Lista

import androidx.lifecycle.ViewModel
import com.ucb.domain.Recordatorio
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.ucb.usecase.MostrarRecordatorio

@HiltViewModel
class ListaViewModel @Inject constructor(
    private val mostrarRecordatorio: MostrarRecordatorio
) : ViewModel() {

    suspend fun obtenerRecordatorios(): List<Recordatorio> {
        return mostrarRecordatorio()
    }
}