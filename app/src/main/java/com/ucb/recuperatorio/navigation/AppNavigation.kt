package com.ucb.recuperatorio.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ucb.recuperatorio.Lista.ListaUI
import com.ucb.recuperatorio.Lista.RegistrarRecordatorioUI
import com.ucb.recuperatorio.Registrar.RegistrarRecordatoriosUI
import com.ucb.recuperatorio.Splash.SplashUI

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var recordatorios by remember { mutableStateOf(
        listOf(
            RegistrarRecordatorioUI("Ir al médico", "2025-06-01", "Muy Importante"),
            RegistrarRecordatorioUI("Estudiar Cálculo", "2025-06-01", "Muy Importante"),
            RegistrarRecordatorioUI("Estudiar Kotlin", "2025-06-02", "Importante"),
        )
    )}

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }


    ) {

        composable(Screen.Splash.route) {
            SplashUI(navController)
        }

        composable(Screen.Registrar.route) {
            RegistrarRecordatoriosUI(
                navController = navController,
                onRegistrar = { nuevo ->
                    recordatorios = (recordatorios + nuevo) as List<RegistrarRecordatorioUI>
                }
            )
        }

        composable(Screen.Lista.route) {
            ListaUI(
                recordatorios = recordatorios,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
