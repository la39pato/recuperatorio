package com.ucb.recuperatorio.Registrar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.tooling.preview.Preview
import com.ucb.recuperatorio.Lista.RegistrarRecordatorioUI
import com.ucb.recuperatorio.navigation.Screen

@Composable
fun RegistrarRecordatoriosUI(
    navController: NavController,
    onRegistrar: (RegistrarRecordatorioUI) -> Unit
) {
    var nombre by remember { mutableStateOf(TextFieldValue("")) }
    var fecha by remember { mutableStateOf(TextFieldValue("")) }
    var importancia by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(0.9f),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
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
                    val nuevoRecordatorio = RegistrarRecordatorioUI(
                        nombre = nombre.text,
                        fecha = fecha.text,
                        importancia = importancia.text
                    )
                    onRegistrar(nuevoRecordatorio)
                    navController.navigate(Screen.Lista.route)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrar")
            }

            Button(
                onClick = {
                    navController.navigate(Screen.Lista.route)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver recordatorios registrados")
            }
        }
    }
}


@Preview
@Composable
fun RegistrarRecordatoriosPreview() {
    RegistrarRecordatoriosUI(
        navController = rememberNavController(),
        onRegistrar = { println(it) }
    )
}


