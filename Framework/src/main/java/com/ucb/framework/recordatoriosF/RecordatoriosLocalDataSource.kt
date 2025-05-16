package com.ucb.framework.recordatoriosF

import android.content.Context
import com.ucb.domain.Recordatorio
import com.ucb.framework.Mappers.toEntity
import com.ucb.framework.persistencia.AppRoomDatabase
import com.ucb.framework.persistencia.IRecordatoriosDao
import com.ucb.data.ILocalRecordatorioDataSource

class RecordatoriosLocalDataSource(val context: Context) : ILocalRecordatorioDataSource {
    val recordatoriosDAO: IRecordatoriosDao = AppRoomDatabase.getDatabase(context).recordatoriosDao()
    override suspend fun insertar(recordatorio: Recordatorio): Boolean {
        recordatoriosDAO.insert(recordatorio.toEntity())
        return true
    }
    override suspend fun obtenerTodos(): List<Recordatorio> {
        val entidades = recordatoriosDAO.getRecordatorios()
        val listaDominio = entidades.map { recordatorio -> recordatorio.toDomain() }
        return listaDominio
    }
}
