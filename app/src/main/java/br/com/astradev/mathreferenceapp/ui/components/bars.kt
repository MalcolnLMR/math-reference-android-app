package br.com.astradev.mathreferenceapp.ui.components

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.outlined.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.astradev.mathreferenceapp.R
import br.com.astradev.mathreferenceapp.ui.screens.objects.Routes
import br.com.astradev.mathreferenceapp.ui.theme.AccentLight
import br.com.astradev.mathreferenceapp.ui.theme.Black
import br.com.astradev.mathreferenceapp.ui.theme.PrimaryLight
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

data class BottomBarItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val navigationRoute: String,
    val badgeAmount: Int? = null
)

@Composable
fun BottomBarIconView(
    isSelected: Boolean,
    selectedIcon: ImageVector,
    unselectedIcon: ImageVector,
    title: String
) {
    Icon(
        imageVector = if (isSelected) {selectedIcon} else {unselectedIcon},
        contentDescription = title
    )
}

@Composable
fun HomeBottomBar(navController: NavController){
    var selectedBarIndex by rememberSaveable {
        mutableIntStateOf(1)
    }

    val homeItem = BottomBarItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        navigationRoute = Routes.HOME_SCREEN
    )
    val tosItem = BottomBarItem(
        title = "Termos",
        selectedIcon = Icons.Filled.Info,
        unselectedIcon = Icons.Outlined.Info,
        navigationRoute = Routes.TOS_SCREEN
    )
    val profileItem = BottomBarItem(
        title = "Perfil",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        navigationRoute = Routes.PROFILE_SCREEN
    )
    val logoutItem = BottomBarItem(
        title = "Sair",
        selectedIcon = Icons.AutoMirrored.Filled.ExitToApp,
        unselectedIcon = Icons.AutoMirrored.Outlined.ExitToApp,
        navigationRoute = Routes.LOGOUT_SCREEN
    )

    val bottomBarItems = listOf(tosItem, homeItem, profileItem, logoutItem)

    NavigationBar (
        containerColor = SecondaryLight,
        contentColor = PrimaryLight
    ) {
        bottomBarItems.forEachIndexed { index, bottomBarItem ->
            NavigationBarItem(
                colors = NavigationBarItemColors(
                    selectedIconColor = SecondaryLight,
                    selectedTextColor = SecondaryLight,
                    selectedIndicatorColor = AccentLight,
                    unselectedIconColor = Black,
                    unselectedTextColor = Black,
                    disabledIconColor = Black,
                    disabledTextColor = Black
                ),
                modifier = Modifier
                    .background(AccentLight, RoundedCornerShape(30.dp))
                    .width(10.dp).height(60.dp),
                selected = selectedBarIndex == index,
                onClick = {
                    selectedBarIndex = index
                    navController.navigate(bottomBarItem.navigationRoute)
                },
                icon = {
                    BottomBarIconView(
                        isSelected = selectedBarIndex == index,
                        selectedIcon = bottomBarItem.selectedIcon,
                        unselectedIcon = bottomBarItem.unselectedIcon,
                        title = bottomBarItem.title
                    )
                },
                label = { Text(bottomBarItem.title) })
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun BarWithBackground(){
    mathreferenceappTheme {
        Scaffold(
            topBar = { HomeTopBar("Preview") },
            bottomBar = { HomeBottomBar(rememberNavController()) }
        ) {
            HomeBackground()

        }
    }
}