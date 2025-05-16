package com.ucb.framework.persistencia

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ucb.domain.Recordatorio
import java.time.LocalDateTime

@Entity(tableName = "recordatorios")
data class Recordatorios(
    @PrimaryKey(autoGenerate = true) val
    id: Int = 0,
    val nombre: String,
    val fecha: String,
    val importancia:String
) {
    fun toDomain(): Recordatorio {
        return Recordatorio(
            nombre = this.nombre,
            fecha = this.fecha,
            importancia = this.importancia
        )
    }
}