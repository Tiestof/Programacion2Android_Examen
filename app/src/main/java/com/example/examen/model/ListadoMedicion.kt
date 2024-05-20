package com.example.examen.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.examen.R

@Composable
fun pageHome(navController: NavController, viewModel: MedicionViewModel = viewModel()) {
    val gasicon: Int = R.drawable.gasicon
    val aguaicon: Int = R.drawable.aguaicon
    val luzicon: Int = R.drawable.luzicon

    LazyColumn(
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        items(viewModel.registros) { item ->
            var decision = when (item.tipo) {
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
