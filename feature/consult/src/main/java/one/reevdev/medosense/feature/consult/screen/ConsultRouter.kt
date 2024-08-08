package one.reevdev.medosense.feature.consult.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import one.reevdev.medosense.feature.consult.navigation.ConsultRoutes
import one.reevdev.medosense.feature.consult.navigation.analysisResultScreen
import one.reevdev.medosense.feature.consult.navigation.cameraScreen
import one.reevdev.medosense.feature.consult.navigation.confirmMedicineScreen
import one.reevdev.medosense.feature.consult.navigation.illnessRouter
import one.reevdev.medosense.feature.consult.navigation.navigateToAnalysisResult
import one.reevdev.medosense.feature.consult.navigation.navigateToCamera
import one.reevdev.medosense.feature.consult.navigation.navigateToConfirmMedicine
import one.reevdev.medosense.feature.consult.navigation.navigateToIllnessRouter
import one.reevdev.medosense.feature.consult.screen.medicine.MedicineViewModel

@Composable
fun ConsultRouter(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: MedicineViewModel = hiltViewModel(),
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
                    viewModel.setAnalysis(analysis)
                    navController.navigateToAnalysisResult(analysis)
                }
            )
            analysisResultScreen(
                onConfirmClick = { navController.navigateToCamera() },
                onContinueClick = {
                    viewModel.resetGemini()
                    navController.navigateToIllnessRouter()
                }
            )
            cameraScreen(
                viewModel = viewModel,
                onProceedToMedicineConfirmation = {
                    navController.navigateToConfirmMedicine()
                }
            )
            confirmMedicineScreen(
                viewModel = viewModel,
                onConfirmClick = { navController.navigateToCamera() },
                onContinueClick = {
                    viewModel.resetGemini()
                    navController.navigateToIllnessRouter()
                }
            )
        }
    }
}