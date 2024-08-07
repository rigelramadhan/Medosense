package one.reevdev.medosense.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import one.reevdev.medosense.feature.consult.navigation.ConsultRoutes
import one.reevdev.medosense.feature.consult.navigation.consultRouter

@Composable
fun MedosenseApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: Any = ConsultRoutes.ConsultRouter
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        consultRouter()
    }
}