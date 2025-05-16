package com.ucb.recuperatorio.Splash
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import com.ucb.recuperatorio.navigation.Screen

@Composable
fun SplashUI(navController: NavController) {

    var hasNavigated by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(3000)
        if (!hasNavigated) {
            hasNavigated = true
            navController.navigate(Screen.Registrar.route) {
                popUpTo(Screen.Splash.route) { inclusive = true }
            }
        }
    }

    // Contenido centrado en pantalla
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Recordatorios",
            fontSize = 32.sp,
            style = MaterialTheme.typography.headlineLarge
            )
    }
}
