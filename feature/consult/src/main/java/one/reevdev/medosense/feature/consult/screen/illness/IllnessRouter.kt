package one.reevdev.medosense.feature.consult.screen.illness

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import one.reevdev.medosense.core.domain.feature.consult.model.IllnessAnalysis
import one.reevdev.medosense.feature.common.state.LoadingState
import one.reevdev.medosense.feature.consult.navigation.ConsultRoutes
import one.reevdev.medosense.feature.consult.navigation.illnessConfirmationScreen
import one.reevdev.medosense.feature.consult.navigation.inputIllnessScreen
import one.reevdev.medosense.feature.consult.navigation.navigateToIllnessConfirmation

@Composable
fun IllnessRouter(
    modifier: Modifier = Modifier,
    viewModel: IllnessViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController(),
    startDestination: Any = ConsultRoutes.InputIllness,
    onAnalysisResultAvailable: (IllnessAnalysis) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = uiState.diggingResult) {
        val illnessAnalysis = uiState.diggingResult?.illnessAnalysis
        illnessAnalysis?.let(onAnalysisResultAvailable)
    }

    Scaffold(
        modifier = modifier
    ) {
        NavHost(
            modifier = Modifier
                .padding(it),
            navController = navController,
            startDestination = startDestination
        ) {
            inputIllnessScreen(
                onContinueClick = { symptoms ->
                    viewModel.submitSymptoms(symptoms)
                    navController.navigateToIllnessConfirmation()
                }
            )
            illnessConfirmationScreen(
                isLoading = uiState.loadingState != LoadingState.NotLoading,
                question = uiState.diggingResult?.question.orEmpty(),
                onButtonClick = { isYes -> viewModel.answerDiggingQuestion(isYes) }
            )
        }
    }
}