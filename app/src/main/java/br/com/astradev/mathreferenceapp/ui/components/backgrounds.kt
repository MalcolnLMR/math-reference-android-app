package br.com.astradev.mathreferenceapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.astradev.mathreferenceapp.R
import br.com.astradev.mathreferenceapp.ui.theme.PrimaryLight
import br.com.astradev.mathreferenceapp.ui.theme.mathreferenceappTheme

@Composable
fun MainBackground(){
    Box(Modifier.fillMaxSize().background(PrimaryLight))

    Image(
        painterResource(R.drawable.bg_art_top),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
    )

    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.fillMaxSize()
    )
    {
        Image(
            painterResource(R.drawable.bg_art_bottom),
            contentDescription = "",
            contentScale = ContentScale.Crop,

            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainBackgroundPreview(){
    mathreferenceappTheme {
        MainBackground()
    }
}

@Composable
fun HomeBackground(){
    Box(Modifier.fillMaxSize().background(PrimaryLight))
}

@Preview(showBackground = true)
@Composable
fun HomeBackgroundPreview(){
    mathreferenceappTheme {
        HomeBackground()
    }
}