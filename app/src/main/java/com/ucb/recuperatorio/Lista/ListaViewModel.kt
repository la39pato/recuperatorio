package com.ucb.recuperatorio.Lista

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.viewModelScope

class listaViewModel(
//    private val obtenerRecordatoriosUseCase: ObtenerRecordatoriosUseCase
) {
//    private val _recordatorios = MutableStateFlow<List<RecordatorioUI>>(emptyList())
//    val recordatorios: StateFlow<List<RecordatorioUI>> = _recordatorios
//
//    fun cargarRecordatorios() {
//        viewModelScope.launch {
//            val listaDomain = obtenerRecordatoriosUseCase.ejecutar()
//
//            // Convertimos a modelo de la UI
//            val listaUI = listaDomain.map { recordatorio ->
//                RecordatorioUI(
//                    nombre = recordatorio.nombre,
//                    fecha = recordatorio.fecha,
//                    importancia = recordatorio.importancia
//                )
//            }
//
//            _recordatorios.value = listaUI
//        }
//    }
}
