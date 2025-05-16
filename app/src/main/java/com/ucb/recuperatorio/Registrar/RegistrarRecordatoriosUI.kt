package com.ucb.recuperatorio.Registrar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RegistrarRecordatoriosUI(
    navController: NavController,
    viewModel: RegistrarRecordatorioViewModel = viewModel()
) {
    var nombre by remember { mutableStateOf(TextFieldValue("")) }
    var fecha by remember { mutableStateOf(TextFieldValue("")) }
    var importancia by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Registrar Recordatorio", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = fecha,
            onValueChange = { fecha = it },
            label = { Text("Fecha") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = importancia,
            onValueChange = { importancia = it },
            label = { Text("Importancia") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                viewModel.registrar(
                    nombre.text,
                    fecha.text,
                    importancia.text
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar")
            }
        }
}

@Preview
@Composable
fun RegistrarRecordatoriosPreview() {
    RegistrarRecordatoriosUI(navController = rememberNavController())
}

