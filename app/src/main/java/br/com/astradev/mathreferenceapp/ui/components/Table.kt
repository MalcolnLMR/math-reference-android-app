package br.com.astradev.mathreferenceapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.astradev.mathreferenceapp.ui.theme.AccentLight
import br.com.astradev.mathreferenceapp.ui.theme.Black
import br.com.astradev.mathreferenceapp.ui.theme.PrimaryLight
import br.com.astradev.mathreferenceapp.ui.theme.White
import br.com.astradev.mathreferenceapp.ui.theme.mathreferenceappTheme
import kotlin.math.pow
import kotlin.math.round

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}

@Composable
fun GeometryTable(tableData: List<Triple<String, String, () -> Double>>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            //.padding(16.dp)
    ) {
        TableHeader()
        Spacer(modifier = Modifier.height(1.dp))
        tableData.forEach { (dimension, formula, result) ->
            TableRow(dimension, formula, result)
            HorizontalDivider(thickness = 1.dp, color = PrimaryLight)
        }
    }
}

@Composable
fun TableHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(AccentLight)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Dimensões",
            modifier = Modifier.weight(1f),
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            color = Black
        )
        Text(
            text = "Fórmulas",
            modifier = Modifier.weight(1f),
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            color = Black
        )
        Text(
            text = "Resultados",
            modifier = Modifier.weight(1f),
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            color = Black
        )
    }
}

@Composable
fun TableRow(dimension: String, formula: String, result: () -> Double) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = dimension,
            modifier = Modifier.weight(1f),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Black

        )
        Text(
            text = formula,
            modifier = Modifier.weight(1f),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Black
        )
        Text(
            text = result.invoke().round(3).toString(),
            modifier = Modifier.weight(1f),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Black
        )
    }
}

@Preview
@Composable
fun TablePreview(){
    mathreferenceappTheme {
        Surface (modifier = Modifier.fillMaxSize()) {
            HomeBackground()

            GeometryTable(
                listOf(
                    Triple("Círculo", "π × r²") {
                        val result = Math.PI * (2.0.pow(2.0))
                        result
                    },
                    Triple("Circunferência", "π × r²") {
                    val result = Math.PI * (2.0.pow(2.0))
                    result
                }
                )
            )
        }
    }
}