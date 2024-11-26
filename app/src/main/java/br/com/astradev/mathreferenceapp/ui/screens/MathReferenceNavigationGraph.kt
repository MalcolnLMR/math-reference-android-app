package br.com.astradev.mathreferenceapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.astradev.mathreferenceapp.ui.screens.geometry.CircleScreen
import br.com.astradev.mathreferenceapp.ui.screens.geometry.CubeScreen
import br.com.astradev.mathreferenceapp.ui.screens.geometry.RectangleScreen
import br.com.astradev.mathreferenceapp.ui.screens.geometry.RhomboidScreen
import br.com.astradev.mathreferenceapp.ui.screens.geometry.SphereScreen
import br.com.astradev.mathreferenceapp.ui.screens.geometry.SquareScreen
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
        composable(Routes.SPHERE_SCREEN) { SphereScreen(navController) }

        composable(Routes.SQUARE_SCREEN) { SquareScreen(navController) }
        composable(Routes.CUBE_SCREEN) { CubeScreen(navController) }

        composable(Routes.RECTANGLE_SCREEN) { RectangleScreen(navController) }
        composable(Routes.RHOMBOID_SCREEN) { RhomboidScreen(navController) }

        composable(Routes.TRIANGLE_SCREEN) {  } // todo
        composable(Routes.PYRAMID_SCREEN) {  } // todo
    }
}