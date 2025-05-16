package com.ucb.usecase

import com.ucb.data.RecordatorioRepository
import com.ucb.domain.Recordatorio

class MostrarRecordatorio(
    private val repository: RecordatorioRepository
) {
    suspend operator fun invoke(): List<Recordatorio> {
        return repository.obtenerTodos()
    }
}
