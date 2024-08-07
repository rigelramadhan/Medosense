package one.reevdev.medosense.feature.consult.navigation

import android.net.Uri
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import one.reevdev.medosense.core.domain.feature.consult.model.IllnessAnalysis
import one.reevdev.medosense.feature.consult.screen.ConsultRouter
import one.reevdev.medosense.feature.consult.screen.analysis.AnalysisResultRouter
import one.reevdev.medosense.feature.consult.screen.illness.IllnessRouter
import one.reevdev.medosense.feature.consult.screen.illness.confirmation.IllnessConfirmationRouter
import one.reevdev.medosense.feature.consult.screen.illness.input.IllnessInputRouter
import one.reevdev.medosense.feature.consult.screen.medicine.MedicineViewModel
import one.reevdev.medosense.feature.consult.screen.medicine.camera.CameraRouter
import one.reevdev.medosense.feature.consult.screen.medicine.confirmmedicine.ConfirmMedicineRouter
import kotlin.reflect.typeOf

fun NavController.navigateToInputIllness() {
    navigate(ConsultRoutes.InputIllness)
}

fun NavGraphBuilder.inputIllnessScreen(
    onContinueClick: (String) -> Unit
) {
    composable<ConsultRoutes.InputIllness> {
        IllnessInputRouter(
            onContinueClick = onContinueClick
        )
    }
}

fun NavController.navigateToIllnessConfirmation() {
    navigate(ConsultRoutes.Confirmation)
}

fun NavGraphBuilder.illnessConfirmationScreen(
    question: String,
    isLoading: Boolean,
    onButtonClick: (isYes: Boolean) -> Unit
) {
    composable<ConsultRoutes.Confirmation> {
        IllnessConfirmationRouter(
            question = question,
            isLoading = isLoading,
            onButtonClick = onButtonClick
        )
    }
}

fun NavController.navigateToIllnessRouter() {
    navigate(ConsultRoutes.IllnessRouter)
}

fun NavGraphBuilder.illnessRouter(
    onAnalysisResultAvailable: (IllnessAnalysis) -> Unit
) {
    composable<ConsultRoutes.IllnessRouter> {
        IllnessRouter(
            onAnalysisResultAvailable = onAnalysisResultAvailable
        )
    }
}

fun NavController.navigateToAnalysisResult(analysis: IllnessAnalysis) {
    navigate(ConsultRoutes.AnalysisResult(analysis))
}

fun NavGraphBuilder.analysisResultScreen(
    onConfirmClick: () -> Unit,
    onContinueClick: () -> Unit
) {
    composable<ConsultRoutes.AnalysisResult>(
        typeMap = mapOf(typeOf<IllnessAnalysis>() to AnalysisResultParameterType)
    ) {
        val analysis = it.toRoute<ConsultRoutes.AnalysisResult>().analysis
        AnalysisResultRouter(
            analysis = analysis,
            onConfirmClick = onConfirmClick,
            onContinueClick = onContinueClick
        )
    }
}

fun NavController.navigateToCamera() {
    navigate(ConsultRoutes.Camera)
}

fun NavGraphBuilder.cameraScreen(
    viewModel: MedicineViewModel,
    onProceedToMedicineConfirmation: (Uri?) -> Unit
) {
    composable<ConsultRoutes.Camera> {
        CameraRouter(
            viewModel = viewModel,
            proceedToMedicineConfirmation = onProceedToMedicineConfirmation
        )
    }
}

fun NavController.navigateToConfirmMedicine() {
    navigate(ConsultRoutes.ConfirmMedicine) {
        popUpTo(ConsultRoutes.ConfirmMedicine)
    }
}

fun NavGraphBuilder.confirmMedicineScreen(
    viewModel: MedicineViewModel,
    onConfirmClick: () -> Unit,
    onContinueClick: () -> Unit
) {
    composable<ConsultRoutes.ConfirmMedicine> {
        ConfirmMedicineRouter(
            viewModel = viewModel,
            onConfirmClick = onConfirmClick,
            onContinueClick = onContinueClick
        )
    }
}

fun NavController.navigateToConsultRouter() {
    navigate(ConsultRoutes.ConsultRouter)
}

fun NavGraphBuilder.consultRouter() {
    composable<ConsultRoutes.ConsultRouter> {
        ConsultRouter()
    }
}