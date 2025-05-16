package com.ucb.recuperatorio.Lista

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ucb.domain.Recordatorio


@Composable
fun ListaUI(
    viewModel: ListaViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    var listaRecordatorios by remember { mutableStateOf<List<Recordatorio>>(emptyList()) }
    var cargando by remember { mutableStateOf(false) }
    var cargarTrigger by remember { mutableStateOf(false) }

    LaunchedEffect(cargarTrigger) {
        if (cargarTrigger) {
            cargando = true
            val recordatorios = viewModel.obtenerRecordatorios()
            listaRecordatorios = recordatorios.sortedByDescending { importanciaValor(it.importancia) }
            cargando = false
            cargarTrigger = false
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Button(
            onClick = {
                cargarTrigger = true
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Cargar recordatorios")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (cargando) {
            Text(text = "Cargando...", modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            LazyColumn {
                items(listaRecordatorios) { recordatorio ->
                    RecordatorioItem(recordatorio)
                    HorizontalDivider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f))
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onBackClick, modifier = Modifier.align(Alignment.End)) {
            Text(text = "Volver")
        }
    }
}



@Composable
fun RecordatorioItem(recordatorio: Recordatorio) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = "Nombre: ${recordatorio.nombre}", style = MaterialTheme.typography.titleMedium)
        Text(text = "Fecha: ${recordatorio.fecha}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Importancia: ${recordatorio.importancia}", style = MaterialTheme.typography.bodySmall)
    }
}


// ordenar importancia
fun importanciaValor(nivel: String): Int {
    return when (nivel.lowercase()) {
        "muy importante" -> 3
        "importante" -> 2
        "normal" -> 1
        else -> 0
    }
}
