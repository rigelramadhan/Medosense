package one.reevdev.medosense.feature.consult.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import one.reevdev.medosense.feature.consult.navigation.ConsultRoutes
import one.reevdev.medosense.feature.consult.navigation.analysisResultScreen
import one.reevdev.medosense.feature.consult.navigation.illnessRouter
import one.reevdev.medosense.feature.consult.navigation.navigateToAnalysisResult
import one.reevdev.medosense.feature.consult.navigation.navigateToIllnessRouter

@Composable
fun ConsultRouter(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: Any = ConsultRoutes.IllnessRouter
) {
    Scaffold(
        modifier = modifier
    ) {
        NavHost(
            modifier = Modifier
                .padding(it),
            navController = navController,
            startDestination = startDestination
        ) {
            illnessRouter(
                onAnalysisResultAvailable = { analysis ->
                    navController.navigateToAnalysisResult(analysis)
                }
            )
            analysisResultScreen(
                onConfirmClick = {},
                onContinueClick = { navController.navigateToIllnessRouter() }
            )
        }
    }
}