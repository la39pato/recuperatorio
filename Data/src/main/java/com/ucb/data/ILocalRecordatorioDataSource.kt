package com.ucb.data

import com.ucb.domain.Recordatorio

interface ILocalRecordatorioDataSource {
    suspend fun insertar(recordatorio: Recordatorio)
    suspend fun obtenerTodos(): List<Recordatorio>
}