package br.com.astradev.mathreferenceapp.ui.components

import android.widget.Space
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.astradev.mathreferenceapp.R
import br.com.astradev.mathreferenceapp.ui.theme.AccentLight
import br.com.astradev.mathreferenceapp.ui.theme.Black
import br.com.astradev.mathreferenceapp.ui.theme.SecondaryLight
import br.com.astradev.mathreferenceapp.ui.theme.mathreferenceappTheme

@Composable
fun HomeTopBar(title: String, @DrawableRes icon: Int? = null){
    val height = 75.dp

    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .background(SecondaryLight)
            .height(height)
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Image(
                painterResource(R.drawable.square_pfp),
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(65.dp)
            )

            Spacer(Modifier.weight(1f))

            Box(Modifier.offset(y= (-10).dp)){
                Row(
                    modifier = Modifier
                        .background(AccentLight, RoundedCornerShape(bottomStart = 100.dp))
                        .height(height - 20.dp)
                        .width(250.dp)
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically

                ){
                    Text(
                        title,
                        color = Black,
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        modifier = Modifier
                            .height(100.dp)
                            .wrapContentHeight()
                    )

                    if (icon != null){
                        Spacer(Modifier.size(10.dp))

                        Image(
                            painterResource(icon),
                            contentDescription = "Cubo",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HomeBottomBar(){

}

@Preview
@Composable
fun BarsWithBackground(){
    mathreferenceappTheme {
        HomeBackground()
        Row {
            HomeTopBar("Home", R.drawable.cube)
            // CONTENT
            Spacer(modifier = Modifier.size(50.dp))
            //HomeBottomBar()
        }

    }
}