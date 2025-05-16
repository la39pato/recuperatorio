package com.ucb.recuperatorio.navigation

sealed class Screen(val route: String) {
    object Splash: Screen("splash")
    object Registrar: Screen("registrar")
    object Lista: Screen("lista")
}