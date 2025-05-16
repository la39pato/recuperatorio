package com.ucb.data

import com.ucb.domain.Recordatorio

class RecordatorioRepository (
    private val localDataSource: ILocalRecordatorioDataSource
) {
    //guarda los recordatorios
    suspend fun registrarRecordatorio(recordatorio: Recordatorio) {
        localDataSource.insertar(recordatorio)
    }

    suspend fun obtenerTodos(): List<Recordatorio> {
        return localDataSource.obtenerTodos()
    }
}
