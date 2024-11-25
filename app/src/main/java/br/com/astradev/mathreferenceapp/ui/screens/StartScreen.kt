package br.com.astradev.mathreferenceapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.astradev.mathreferenceapp.R
import br.com.astradev.mathreferenceapp.ui.components.AccentButton
import br.com.astradev.mathreferenceapp.ui.components.MainBackground
import br.com.astradev.mathreferenceapp.ui.screens.objects.Routes
import br.com.astradev.mathreferenceapp.ui.theme.BaseLight
import br.com.astradev.mathreferenceapp.ui.theme.Black
import br.com.astradev.mathreferenceapp.ui.theme.mathreferenceappTheme

@Composable
fun StartScreen(navController: NavController) {
    val spacerSize = 40.dp

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
            Text(
                text = "Referências de Matemática",
                modifier = Modifier
                    .padding(horizontal = 3.dp)
                    .widthIn(min = 50.dp),
                color = Black,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.size(spacerSize - 20.dp))

            Image(
                painterResource(R.drawable.math),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(70.dp)
            )

            Spacer(modifier = Modifier.size(spacerSize))

            AccentButton("Login",
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp)
            )
            { navController.navigate(Routes.LOGIN_SCREEN) }
            
            Spacer(modifier = Modifier.size(spacerSize - 20.dp))

            AccentButton("Cadastrar",
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp)
            )
            { navController.navigate(Routes.REGISTER_SCREEN) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview(){
    mathreferenceappTheme {
        StartScreen(rememberNavController())
    }
}