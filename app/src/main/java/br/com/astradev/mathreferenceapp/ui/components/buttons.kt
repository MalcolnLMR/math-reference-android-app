package br.com.astradev.mathreferenceapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.astradev.mathreferenceapp.R
import br.com.astradev.mathreferenceapp.ui.theme.AccentLight
import br.com.astradev.mathreferenceapp.ui.theme.BaseLight
import br.com.astradev.mathreferenceapp.ui.theme.Black
import br.com.astradev.mathreferenceapp.ui.theme.mathreferenceappTheme

@Composable
fun AccentButton(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = Black,
    backgroundColor: Color = AccentLight,
    roundedRadius: Dp = 10.dp,
    height: Dp = 30.dp,
    onClick: () -> Unit
) {
    Surface (
        color = backgroundColor,
        shape = RoundedCornerShape(roundedRadius),
        modifier = modifier
    ){
        Box(
            modifier = Modifier
                .sizeIn(minWidth = 100.dp)
                .height(height = height)
                .padding(horizontal = 10.dp)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ){
            Text(
                text,
                color = textColor,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .height(height)
                    .wrapContentHeight()
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ButtonPreview(){
    mathreferenceappTheme {
        AccentButton(
            text = "entrar"
        ) {}
    }
}

@Composable
fun ShapeButton(
    text: String,
    textColor: Color = Black,
    backgroundColor: Color = BaseLight,
    roundedRadius: Dp = 10.dp,
    onClick: () -> Unit,
    @DrawableRes icon: Int
) {
    Box(
        modifier = Modifier.size(160.dp),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(backgroundColor, RoundedCornerShape(roundedRadius))
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ){
            Image(
                painterResource(icon),
                contentDescription = "Cubo",
                modifier = Modifier.size(75.dp)
            )
        }

        Box(Modifier.offset(y = ((150.dp - 40.dp)/2))) {
            Box(
                modifier = Modifier
                    .width(160.dp)
                    .height(30.dp)
                    .background(AccentLight, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text,
                    color = textColor,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun ShapeButtonPreview(){
    mathreferenceappTheme {
        ShapeButton(
            text = "Cubo",
            icon = R.drawable.cube,
            onClick = {}
        )
    }
}

@Composable
fun ShapeButtonWithoutIcon(
    text: String,
    textColor: Color = Black,
    backgroundColor: Color = BaseLight,
    roundedRadius: Dp = 10.dp,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier.size(160.dp),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
                .background(backgroundColor, RoundedCornerShape(roundedRadius))
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ){}

        Box() {
            Box(
                modifier = Modifier
                    .width(160.dp)
                    .height(30.dp)
                    .background(AccentLight, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text,
                    color = textColor,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun ShapeButtonWithoutIconPreview(){
    mathreferenceappTheme {
        ShapeButtonWithoutIcon(
            text = "Cubo",
            onClick = {}
        )
    }
}