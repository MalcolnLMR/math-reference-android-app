package br.com.astradev.mathreferenceapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.astradev.mathreferenceapp.ui.screens.geometry.CircleScreen
import br.com.astradev.mathreferenceapp.ui.screens.objects.Routes

@Composable
fun MathReferenceNavigationGraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.START_SCREEN)
    {
        composable(Routes.START_SCREEN) { StartScreen(navController) }
        composable(Routes.LOGIN_SCREEN){ LoginScreen(navController) }
        composable(Routes.REGISTER_SCREEN){ RegisterScreen(navController) }
        composable(Routes.REGISTER_SUCCESS_SCREEN){ RegisterSuccessScreen(navController) }
        composable(Routes.HOME_SCREEN){ HomeScreen(navController) }
        composable(Routes.LOGOUT_SCREEN) { LoginScreen(navController) } // volta pro login
        composable(Routes.TOS_SCREEN) { ToSScreen(navController) }
        composable(Routes.PROFILE_SCREEN) { ProfileScreen(navController) }

        composable(Routes.CIRCLE_SCREEN) { CircleScreen(navController) }
        composable(Routes.SPHERE_SCREEN) {  }

        composable(Routes.SQUARE_SCREEN) {  }
        composable(Routes.CUBE_SCREEN) {  }

        composable(Routes.RECTANGLE_SCREEN) {  }
        composable(Routes.RHOMBOID_SCREEN) {  }

        composable(Routes.TRIANGLE_SCREEN) {  }
        composable(Routes.PYRAMID_SCREEN) {  }
    }
}