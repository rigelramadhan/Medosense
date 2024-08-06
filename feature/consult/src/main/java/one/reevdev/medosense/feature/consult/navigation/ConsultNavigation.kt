package one.reevdev.medosense.feature.consult.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import one.reevdev.medosense.feature.consult.screen.illness.confirmation.IllnessConfirmationRouter
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

fun NavController.navigateToIllnessConfirmation() {
    navigate(ConsultRoutes.Confirmation)
}

fun NavGraphBuilder.illnessConfirmationScreen(
    onYesClick: () -> Unit,
    onNoClick: () -> Unit
) {
    composable<ConsultRoutes.Confirmation> {
        IllnessConfirmationRouter(
            onYesClick = onYesClick,
            onNoClick = onNoClick
        )
    }
}