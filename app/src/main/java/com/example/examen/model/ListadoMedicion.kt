package com.example.examen.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.examen.R

@Composable
// pagina principal para listar los registros guardados
fun pageHome(navController: NavController, viewModel: MedicionViewModel = viewModel()) {

    // variables para identificar que Iconno usaramos
    val gasicon: Int = R.drawable.gasicon
    val aguaicon: Int = R.drawable.aguaicon
    val luzicon: Int = R.drawable.luzicon

    val registros by viewModel.allMediciones.collectAsState(initial = emptyList())

    // uso del LazyColumn
    LazyColumn(
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        items(registros) { item ->
            // en base al valor que llega reescribimos la variable decicion para pintar el icono
            val decision = when (item.tipo) {
                "Agua", "Water" -> aguaicon
                "Luz", "Electricity" -> luzicon
                else -> gasicon
            }
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Image(
                        painter = painterResource(decision),
                        contentDescription = "Imagen de ejemplo",
                        modifier = Modifier.size(20.dp)
                    )
                    Text(item.tipo, modifier = Modifier.weight(1f))
                    Text(item.medidor, modifier = Modifier.weight(1f))
                    Text(item.fecha, modifier = Modifier.weight(1f))
                }
                Divider(color = Color.Gray, thickness = 1.dp)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        FloatingActionButton(
            onClick = {
                navController.navigate("formulario")
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add"
            )
        }
    }
}

