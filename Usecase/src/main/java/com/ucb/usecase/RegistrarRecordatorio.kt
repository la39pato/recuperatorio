package com.ucb.usecase

import com.ucb.data.RecordatorioRepository
import com.ucb.domain.Recordatorio

class RegistrarRecordatorio(
    private val repository: RecordatorioRepository
) {
    //caso de uso para guarda los recordatorios
    suspend operator fun invoke(nombre: String, fecha: String, importancia: String) {
        val recordatorio = Recordatorio(nombre, fecha, importancia)
        repository.registrarRecordatorio(recordatorio)
    }
}