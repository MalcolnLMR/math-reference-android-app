package br.com.astradev.mathreferenceapp.ui.screens.geometry

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.astradev.mathreferenceapp.ui.components.AccentButton
import br.com.astradev.mathreferenceapp.ui.components.GeometryTable
import br.com.astradev.mathreferenceapp.ui.components.HomeBackground
import br.com.astradev.mathreferenceapp.ui.components.HomeBottomBar
import br.com.astradev.mathreferenceapp.ui.components.HomeTopBar
import br.com.astradev.mathreferenceapp.ui.theme.Black
import br.com.astradev.mathreferenceapp.ui.theme.Black50
import br.com.astradev.mathreferenceapp.ui.theme.White
import br.com.astradev.mathreferenceapp.ui.theme.mathreferenceappTheme
import kotlin.math.pow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CircleScreen(navController: NavController) {
    val shapeName = "Circulo"

    var radius by remember { mutableDoubleStateOf(0.0) }

    val tableData = listOf(
        Triple("Área", "π × r²") {
            Math.PI * (radius.pow(2))
        },
        Triple("Diâmetro", "2 × r") {
            2 * radius
        },
        Triple("Circunferência", "2 × π × r") {
            2 * Math.PI * radius
        },
        Triple("Perímetro", "2 × π × r") {
            2 * Math.PI * radius
        }
    )

    Scaffold (
        topBar = { HomeTopBar(shapeName) },
        bottomBar = { HomeBottomBar(navController, 5) }
    ) {
        HomeBackground()

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Pegar Raio
            var radiusText by remember { mutableStateOf("0.0") }
            OutlinedTextField(
                value = radiusText,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp)),
                colors = TextFieldDefaults.colors(
                    unfocusedTextColor = Black,
                    focusedTextColor = Black,
                    unfocusedIndicatorColor = White,
                    focusedIndicatorColor = White,
                    unfocusedContainerColor = White,
                    focusedContainerColor = White
                ),
                onValueChange = { radiusText = it },
                label = { Text("Raio (r)", color = White) }
            )

            Spacer(Modifier.size(20.dp))

            AccentButton("Calcular") {
                try {
                    radius = radiusText.toDouble()
                } catch (_: NumberFormatException){
                    radiusText = "0.0"
                }
            }

            Spacer(Modifier.size(60.dp))

            GeometryTable(tableData)
        }
    }
}

@Preview
@Composable
fun CircleScreenPreview(){
    mathreferenceappTheme {
        CircleScreen(rememberNavController())
    }
}