package com.ucb.framework.Mappers

import com.ucb.domain.Recordatorio
import com.ucb.framework.persistencia.Recordatorios

fun Recordatorio.toEntity(): Recordatorios {
    return Recordatorios(
        nombre = this.nombre,
        fecha = this.fecha,
        importancia = this.importancia
    )
}

fun Recordatorio.toDomain(): Recordatorio {
    return Recordatorio(
        nombre = this.nombre,
        fecha = this.fecha,
        importancia = this.importancia
        )
}
