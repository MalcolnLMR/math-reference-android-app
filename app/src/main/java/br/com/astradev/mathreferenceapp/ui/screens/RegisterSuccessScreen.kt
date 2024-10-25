package br.com.astradev.mathreferenceapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.astradev.mathreferenceapp.R
import br.com.astradev.mathreferenceapp.ui.components.MainBackground
import br.com.astradev.mathreferenceapp.ui.screens.objects.Routes
import br.com.astradev.mathreferenceapp.ui.theme.AccentLight
import br.com.astradev.mathreferenceapp.ui.theme.BaseLight
import br.com.astradev.mathreferenceapp.ui.theme.mathreferenceappTheme

@Composable
fun RegisterSuccessScreen(navController: NavController){
    MainBackground()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable { navController.navigate(Routes.HOME_SCREEN) },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Box(
            modifier = Modifier
                .background(BaseLight, RoundedCornerShape(80.dp))
                .padding(20.dp)
                .height(380.dp)
                .width(250.dp),
            contentAlignment = Alignment.Center
        ){
            Box(
                modifier = Modifier
                    .background(AccentLight, CircleShape)
                    .size(240.dp),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painterResource(R.drawable.check_symbol),
                    contentDescription = "Sucesso",
                    modifier = Modifier.size(100.dp)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun RegisterSuccessScreenPreview(){
    mathreferenceappTheme {
        RegisterSuccessScreen(rememberNavController())
    }
}