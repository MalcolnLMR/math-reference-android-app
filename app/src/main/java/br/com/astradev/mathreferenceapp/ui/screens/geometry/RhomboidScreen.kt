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
import br.com.astradev.mathreferenceapp.ui.theme.White
import br.com.astradev.mathreferenceapp.ui.theme.mathreferenceappTheme
import kotlin.math.pow
import kotlin.math.sqrt

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RhomboidScreen(navController: NavController) {
    val shapeName = "Paralelepipedo"

    var width by remember { mutableDoubleStateOf(0.0) }
    var height by remember { mutableDoubleStateOf(0.0) }
    var length by remember { mutableDoubleStateOf(0.0) }

    val tableData = listOf(
        Triple("Área", "2hL + 2hw + 2Lw") {
            2 * height * length + 2 * height * width + 2 * length * width
        },
        Triple("Perímetro", "4 × (l + h + w)") {
            4 * (length + height + width)
        },
        Triple("Volume", "L × h × w") {
            length * width * height
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

            // Pegar altura
            var heightText by remember { mutableStateOf("0.0") }
            OutlinedTextField(
                value = heightText,
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
                onValueChange = { heightText = it },
                label = { Text("Altura (h)", color = White) }
            )

            // Pegar largura
            var lengthText by remember { mutableStateOf("0.0") }
            OutlinedTextField(
                value = lengthText,
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
                onValueChange = { lengthText = it },
                label = { Text("Largura (L)", color = White) }
            )

            // Pegar comprimento
            var widthText by remember { mutableStateOf("0.0") }
            OutlinedTextField(
                value = widthText,
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
                onValueChange = { widthText = it },
                label = { Text("comprimento (w)", color = White) }
            )

            Spacer(Modifier.size(20.dp))

            AccentButton("Calcular") {
                try {
                    length = lengthText.toDouble()
                    height = heightText.toDouble()
                    width = widthText.toDouble()
                } catch (_: NumberFormatException){
                    lengthText = "0.0"
                    widthText = "0.0"
                    heightText = "0.0"
                }
            }

            Spacer(Modifier.size(60.dp))

            GeometryTable(tableData)
        }
    }
}

@Preview
@Composable
fun RhomboidScreenPreview(){
    mathreferenceappTheme {
        RhomboidScreen(rememberNavController())
    }
}