package com.ucb.recuperatorio.Lista

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


data class RegistrarRecordatorioUI(
    val nombre: String,
    val fecha: String,
    val importancia: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaUI(
    recordatorios: List<RegistrarRecordatorioUI>,
    onBackClick: () -> Unit
) {
    fun prioridadImportancia(imp: String): Int {
        return when (imp) {
            "Muy Importante" -> 1
            "Importante" -> 2
            "Normal" -> 3
            else -> 4
        }
    }

    val recordatoriosOrdenados = recordatorios.sortedBy { prioridadImportancia(it.importancia) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de Recordatorios") },
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(recordatoriosOrdenados) { recordatorio ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Nombre: ${recordatorio.nombre}",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "Fecha: ${recordatorio.fecha}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Importancia: ${recordatorio.importancia}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListaUiPreview() {
    ListaUI(recordatorios = emptyList(), onBackClick = {})
}

