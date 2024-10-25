package br.com.astradev.mathreferenceapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.astradev.mathreferenceapp.ui.screens.objects.Routes
import br.com.astradev.mathreferenceapp.ui.theme.mathreferenceappTheme


@Composable
fun RegisterScreen(navController: NavController){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navController.navigate(Routes.LOGIN_SCREEN)
            }
    ) {
        Text("register_SCREEN")
    }
}

@Composable
@Preview(showBackground = true)
fun RegisterScreenPreview(){
    mathreferenceappTheme {
        RegisterScreen(rememberNavController())
    }
}