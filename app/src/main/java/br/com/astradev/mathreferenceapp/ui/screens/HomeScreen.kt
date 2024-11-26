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
import br.com.astradev.mathreferenceapp.ui.components.ShapeButtonWithoutIcon
import br.com.astradev.mathreferenceapp.ui.components.ShapeButtonWithoutIconPreview
import br.com.astradev.mathreferenceapp.ui.screens.objects.Routes
import br.com.astradev.mathreferenceapp.ui.theme.mathreferenceappTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = { HomeTopBar("Home") },
        bottomBar = { HomeBottomBar(navController, 1) }
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
                    ShapeButtonWithoutIcon(
                        text = "Circulo",
                        onClick = { navController.navigate(Routes.CIRCLE_SCREEN) }
                    )

                    ShapeButtonWithoutIcon(
                        text = "Esfera",
                        onClick = { navController.navigate(Routes.SPHERE_SCREEN) }
                    )
                }

                // ROW 2
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ShapeButtonWithoutIcon(
                        text = "Quadrado",
                        onClick = { navController.navigate(Routes.SQUARE_SCREEN) }
                    )

                    ShapeButtonWithoutIcon(
                        text = "Cubo",
                        onClick = { navController.navigate(Routes.CUBE_SCREEN) }
                    )
                }

                // ROW 3
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ShapeButtonWithoutIcon(
                        text = "Retângulo",
                        onClick = { navController.navigate(Routes.RECTANGLE_SCREEN) }
                    )

                    ShapeButtonWithoutIcon(
                        text = "Paralelepipedo",
                        onClick = { navController.navigate(Routes.RHOMBOID_SCREEN) }
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