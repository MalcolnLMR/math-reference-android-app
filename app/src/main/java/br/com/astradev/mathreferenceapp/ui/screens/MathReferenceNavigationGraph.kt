package br.com.astradev.mathreferenceapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.astradev.mathreferenceapp.ui.components.BottomBarItem
import br.com.astradev.mathreferenceapp.ui.screens.objects.Routes

@Composable
fun MathReferenceNavigationGraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.LOGIN_SCREEN)
    {
        composable(Routes.LOGIN_SCREEN){ LoginScreen(navController) }
        composable(Routes.REGISTER_SCREEN){ RegisterScreen(navController) }
        composable(Routes.REGISTER_SUCCESS_SCREEN){ RegisterSuccessScreen(navController) }
        composable(Routes.HOME_SCREEN){ HomeScreen(navController) }
        composable(Routes.LOGOUT_SCREEN) {  } // TODO
        composable(Routes.TOS_SCREEN) {  } // TODO
        composable(Routes.PROFILE_SCREEN) { ProfileScreen(navController) }
    }
}