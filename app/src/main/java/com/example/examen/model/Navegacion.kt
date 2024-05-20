package com.example.examen.model

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun navergar(navController:
             NavHostController = rememberNavController(), viewModel: MedicionViewModel = viewModel()) {
    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") {
            pageHome(navController = navController, viewModel = viewModel)
        }
        composable("formulario") {
            formulario(viewModel = viewModel)
        }
    }
}

