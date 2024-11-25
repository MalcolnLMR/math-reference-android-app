package br.com.astradev.mathreferenceapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.astradev.mathreferenceapp.R
import br.com.astradev.mathreferenceapp.ui.components.HomeBackground
import br.com.astradev.mathreferenceapp.ui.components.HomeBottomBar
import br.com.astradev.mathreferenceapp.ui.components.HomeTopBar
import br.com.astradev.mathreferenceapp.ui.components.MainBackground
import br.com.astradev.mathreferenceapp.ui.components.ShapeButton
import br.com.astradev.mathreferenceapp.ui.theme.mathreferenceappTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = { HomeTopBar("Home") },
        bottomBar = { HomeBottomBar(rememberNavController()) }
    ) {
        HomeBackground()
        Column(
            modifier = Modifier.fillMaxHeight(),
        ) {
            Spacer(Modifier.size(50.dp))

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                // ROW 1
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ShapeButton(
                        text = "Cubo",
                        icon = R.drawable.cube,
                        onClick = {}
                    )

                    ShapeButton(
                        text = "Losango",
                        icon = R.drawable.rhombus,
                        onClick = {}
                    )
                }

                // ROW 2
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ShapeButton(
                        text = "Romboedro",
                        icon = R.drawable.rhombuzoid,
                        onClick = {}
                    )

                    ShapeButton(
                        text = "Esfera",
                        icon = R.drawable.sphere,
                        onClick = {}
                    )
                }

                // ROW 3
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ShapeButton(
                        text = "Trapézio",
                        icon = R.drawable.trapezoid,
                        onClick = {}
                    )
                }

            } // END OF COLUMN
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    mathreferenceappTheme {
        HomeScreen(rememberNavController())
    }
}