package one.reevdev.medosense.feature.consult.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import one.reevdev.medosense.feature.consult.screen.illness.input.IllnessInputRouter

fun NavController.navigateToInputIllness() {
    navigate(ConsultRoutes.InputIllness)
}

fun NavGraphBuilder.inputIllnessScreen(
    onContinueClick: () -> Unit
) {
    composable<ConsultRoutes.InputIllness> {
        IllnessInputRouter(
            onContinueClick = onContinueClick
        )
    }
}