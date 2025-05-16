package com.ucb.data

import com.ucb.domain.Recordatorio

interface ILocalRecordatorioDataSource {
    suspend fun insertar(recordatorio: Recordatorio): Boolean
    suspend fun obtenerTodos(): List<Recordatorio>
}