package com.example.examen.model

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.examen.R

@Preview(showSystemUi = true)
@Composable
fun formulario(viewModel: MedicionViewModel = viewModel()) {
    val contexto = LocalContext.current
    var valor by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var selectedOption by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                text = contexto.getString(R.string.app_name),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }

        Row {
            OutlinedTextField(
                value = valor,
                onValueChange = { valor = it },
                label = { Text(contexto.getString(R.string.input_medidor)) },
                placeholder = { Text("12.000") }
            )
        }
        Row {
            OutlinedTextField(
                value = fecha,
                onValueChange = { fecha = it },
                label = { Text(contexto.getString(R.string.inpput_fecha)) },
                placeholder = { Text("2024-05-19") }
            )
        }
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(text = "Medidos de:")
        }
        RadioButtonRow(selectedOption, contexto.getString(R.string.radiobtn_agua)) { selectedOption = contexto.getString(R.string.radiobtn_agua) }
        RadioButtonRow(selectedOption, contexto.getString(R.string.radiobtn_luz)) { selectedOption = contexto.getString(R.string.radiobtn_luz) }
        RadioButtonRow(selectedOption, contexto.getString(R.string.radiobtn_gas)) { selectedOption = contexto.getString(R.string.radiobtn_gas) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                if (valor.isNotEmpty() && fecha.isNotEmpty() && selectedOption.isNotEmpty()) {
                    viewModel.addMedicion(Medicion(valor, fecha, selectedOption))
                    valor = ""
                    fecha = ""
                    selectedOption = ""
                }
            }) {
                Text(contexto.getString(R.string.btn_registrar_medicion))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            viewModel.registros.forEach { registro ->
                Text("Medidor: ${registro.medidor}, Fecha: ${registro.fecha}, Tipo: ${registro.tipo}")
            }
        }
    }
}

@Composable
fun RadioButtonRow(selectedOption: String, option: String, onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        RadioButton(
            selected = (selectedOption == option),
            onClick = { onClick() }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(option)
    }
}
