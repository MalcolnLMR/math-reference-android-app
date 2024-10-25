package br.com.astradev.mathreferenceapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.astradev.mathreferenceapp.ui.theme.AccentLight
import br.com.astradev.mathreferenceapp.ui.theme.Black
import br.com.astradev.mathreferenceapp.ui.theme.Black50
import br.com.astradev.mathreferenceapp.ui.theme.White
import br.com.astradev.mathreferenceapp.ui.theme.mathreferenceappTheme

@Composable
fun NormalTextField(placeHolder: String, modifier: Modifier = Modifier){
    TextField(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp)),
        placeholder = { Text(placeHolder, color = Black50) },
        value = "",
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Black,
            focusedTextColor = Black,
            unfocusedIndicatorColor = White,
            focusedIndicatorColor = White,
            unfocusedContainerColor = White,
            focusedContainerColor = White

        ),
        onValueChange = {}
    )
}

@Composable
@Preview()
fun NormalTextFieldPreview(){
    mathreferenceappTheme {
        NormalTextField("placeholder")
    }
}