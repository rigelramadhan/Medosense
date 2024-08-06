package one.reevdev.medosense.feature.consult.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import one.reevdev.medosense.core.domain.feature.consult.model.IllnessAnalysis
import one.reevdev.medosense.feature.consult.screen.analysis.AnalysisResultRouter
import one.reevdev.medosense.feature.consult.screen.illness.IllnessRouter
import one.reevdev.medosense.feature.consult.screen.illness.confirmation.IllnessConfirmationRouter
import one.reevdev.medosense.feature.consult.screen.illness.input.IllnessInputRouter
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
    onButtonClick: (isYes: Boolean) -> Unit
) {
    composable<ConsultRoutes.Confirmation> {
        IllnessConfirmationRouter(
            question = question,
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