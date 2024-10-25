package br.com.astradev.mathreferenceapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.astradev.mathreferenceapp.ui.components.AccentButton
import br.com.astradev.mathreferenceapp.ui.components.MainBackground
import br.com.astradev.mathreferenceapp.ui.components.NormalTextField
import br.com.astradev.mathreferenceapp.ui.screens.objects.Routes
import br.com.astradev.mathreferenceapp.ui.theme.BaseLight
import br.com.astradev.mathreferenceapp.ui.theme.mathreferenceappTheme


@Composable
fun RegisterScreen(navController: NavController){
    val spacerSize = 20.dp
    val confirmSpacerSize = 50.dp

    MainBackground()

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(BaseLight, RoundedCornerShape(20.dp))
                .padding(20.dp)
        )
        {
            NormalTextField(placeHolder = "nome")
            Spacer(modifier = Modifier.size(spacerSize))
            NormalTextField(placeHolder = "email")
            Spacer(modifier = Modifier.size(spacerSize))
            NormalTextField(placeHolder = "senha")
            Spacer(modifier = Modifier.size(spacerSize))
            NormalTextField(placeHolder = "confirmar senha")
            Spacer(modifier = Modifier.size(confirmSpacerSize))
            AccentButton("Cadastrar") { }
        }
    }

    AccentButton(
        text = "Login",
        onClick = { navController.navigate(Routes.LOGIN_SCREEN) },
        modifier = Modifier.offset(10.dp, 30.dp)
    )

}

@Composable
@Preview(showBackground = true)
fun RegisterScreenPreview(){
    mathreferenceappTheme {
        RegisterScreen(rememberNavController())
    }
}