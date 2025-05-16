package com.ucb.recuperatorio.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ucb.recuperatorio.Registrar.RegistrarRecordatoriosUI
import com.ucb.recuperatorio.Lista.listaUI
import com.ucb.recuperatorio.Splash.SplashUI

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

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
            RegistrarRecordatoriosUI(navController)
        }
    }
}
