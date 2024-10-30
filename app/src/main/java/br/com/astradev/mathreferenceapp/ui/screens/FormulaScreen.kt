package br.com.astradev.mathreferenceapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.astradev.mathreferenceapp.model.geometry.objects.FormulaNames
import br.com.astradev.mathreferenceapp.model.getGeometryComponent
import br.com.astradev.mathreferenceapp.ui.components.HomeBackground
import br.com.astradev.mathreferenceapp.ui.components.HomeTopBar
import br.com.astradev.mathreferenceapp.ui.components.NormalTextField
import br.com.astradev.mathreferenceapp.ui.screens.objects.Routes
import br.com.astradev.mathreferenceapp.ui.theme.AccentLight
import br.com.astradev.mathreferenceapp.ui.theme.BaseLight
import br.com.astradev.mathreferenceapp.ui.theme.Black
import br.com.astradev.mathreferenceapp.ui.theme.White
import br.com.astradev.mathreferenceapp.ui.theme.mathreferenceappTheme
import br.com.astradev.mathreferenceapp.ui.viewmodels.FormulaInputViewModel

@Composable
fun FormulaScreen(navController: NavController) {
    HomeBackground()

    val component = getGeometryComponent("Cubóide")
    if (component == null) navController.navigate(Routes.HOME_SCREEN)

    var input_1 by remember { mutableDoubleStateOf(0.0) }
    var input_2 by remember { mutableDoubleStateOf(0.0) }
    var input_3 by remember { mutableDoubleStateOf(0.0) }

    HomeTopBar(component!!.name, component.icon)

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End
    ) {
        for (key in component.map.invoke().keys){
            NormalTextField(key)
            Spacer(Modifier.size(5.dp))
        }

        Spacer(Modifier.size(40.dp))

        for (mathComponent in component.formulas){
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(BaseLight, RoundedCornerShape(5.dp))
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = mathComponent.nome + ": ",
                    modifier = Modifier
                        .background(AccentLight, RoundedCornerShape(5.dp))
                        .padding(horizontal = 3.dp)
                        .widthIn(min = 50.dp),
                    color = Black
                )
                /*
                Text(
                    text = mathComponent.formulaText + " = ",
                    modifier = Modifier
                        .background(AccentLight, RoundedCornerShape(5.dp))
                )*/
                Spacer(Modifier.weight(1f))
                Text(
                    text = mathComponent.formula.invoke(
                        // TODO fazer com que isso aqui receba os valores digitados pelo usuário
                        mapOf(
                            FormulaNames.WIDTH to 1.0,
                            FormulaNames.HEIGHT to 1.0,
                            FormulaNames.LENGTH to 1.0
                        )
                    ).toString(),
                    modifier = Modifier
                        .background(White, RoundedCornerShape(5.dp))
                        .padding(horizontal = 3.dp),
                    color = Black

                )
            }
            Spacer(Modifier.fillMaxWidth().height(5.dp))
        }
    }
}

@Preview
@Composable
fun FormulaScreenPreview(){
    mathreferenceappTheme {
        FormulaScreen(rememberNavController())
    }
}