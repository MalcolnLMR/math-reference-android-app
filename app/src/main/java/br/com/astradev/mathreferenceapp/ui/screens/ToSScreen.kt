package br.com.astradev.mathreferenceapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.astradev.mathreferenceapp.ui.components.HomeBackground
import br.com.astradev.mathreferenceapp.ui.components.HomeBottomBar
import br.com.astradev.mathreferenceapp.ui.components.HomeTopBar
import br.com.astradev.mathreferenceapp.ui.theme.BaseLight
import br.com.astradev.mathreferenceapp.ui.theme.Black
import br.com.astradev.mathreferenceapp.ui.theme.mathreferenceappTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ToSScreen(navController: NavController) {
    Scaffold(
        topBar = { HomeTopBar("Termos de Uso") },
        bottomBar = { HomeBottomBar(navController, 0) }
    ) {
        HomeBackground()
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
                    .verticalScroll(ScrollState(0))
            )
            {
                Text(
                    "\n\n\n1. Introdução\n" +
                            "Bem-vindo ao nosso aplicativo! Ao usar o “Referências de Matemática”, você concorda com os seguintes termos. Se não concordar, bem... talvez seja melhor recorrer ao velho compasso e régua.\n" +
                            "\n" +
                            "2. Uso Apropriado\n" +
                            "2.1 Este aplicativo é destinado a pessoas que amam formas geométricas ou que pelo menos sabem diferenciar um triângulo de um círculo. Se você tentar usar este app para encontrar um triângulo amoroso, podemos confirmar: não é esse tipo de triângulo.\n" +
                            "\n" +
                            "2.2 Acreditamos que nenhuma forma é superior à outra. Por favor, evite comentários depreciativos como “O paralelogramo é só um retângulo esquisito” ou “O trapézio nem é um quadrilátero de verdade”. Somos uma comunidade inclusiva e respeitosa.\n" +
                            "\n" +
                            "3. Direitos Autorais e Limites de Uso\n" +
                            "3.1 Copiar descrições de formas geométricas para parecer inteligente no grupo do WhatsApp é permitido, mas não diga que você inventou o dodecaedro. Ninguém vai acreditar.\n" +
                            "\n" +
                            "3.2 Imagens geradas pelo app podem ser usadas para fins educativos, apresentações e para impressionar seu professor de matemática, mas não tente vendê-las no mercado negro de formas raras.\n" +
                            "\n" +
                            "4. Isenção de Responsabilidade\n" +
                            "4.1 O app não se responsabiliza por conflitos familiares gerados por debates como “O círculo é uma forma perfeita?”.\n" +
                            "4.2 Se você passar a ver formas geométricas em todo lugar (nuvens hexagonais, bolos cilíndricos, etc.), saiba que isso é um efeito colateral previsto. Apreciar a geometria é um dom, não um defeito.\n" +
                            "\n" +
                            "5. Alterações nos Termos\n" +
                            "Nós nos reservamos o direito de alterar estes termos a qualquer momento, porque somos imprevisíveis como um polígono irregular. Prometemos, no entanto, manter o humor e a geometria intactos.\n" +
                            "\n" +
                            "6. Consentimento\n" +
                            "Ao clicar em \"Concordo\", você oficialmente entra para o seleto grupo de apaixonados por ângulos e lados. Parabéns! Você está mais perto do que nunca de resolver um enigma geométrico ou, quem sabe, conquistar o coração de um cone.\n" +
                            "\n\n\n\n",
                    color = Black
                )
            }

        }
    }
}

@Preview
@Composable
fun ToSScreenPreview(){
    mathreferenceappTheme {
        ToSScreen(rememberNavController())
    }
}