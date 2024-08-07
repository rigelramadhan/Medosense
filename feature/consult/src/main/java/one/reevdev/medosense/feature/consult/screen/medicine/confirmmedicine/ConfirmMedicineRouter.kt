package one.reevdev.medosense.feature.consult.screen.medicine.confirmmedicine

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import one.reevdev.medosense.feature.common.component.AppHeader
import one.reevdev.medosense.feature.common.theme.appColors
import one.reevdev.medosense.feature.consult.screen.medicine.MedicineViewModel

@Composable
fun ConfirmMedicineRouter(
    modifier: Modifier = Modifier,
    viewModel: MedicineViewModel = hiltViewModel(),
    onConfirmClick: () -> Unit,
    onContinueClick: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier,
        containerColor = appColors().primary,
        topBar = {
            AppHeader(
                background = appColors().primary,
                logoTint = appColors().onPrimary
            )
        }
    ) {
        ConfirmMedicineScreen(
            modifier = Modifier
                .padding(it),
            confirmResult = uiState.result?.response.orEmpty(),
            photo = uiState.photo,
            onConfirmClick = onConfirmClick,
            onContinueClick = onContinueClick
        )
    }
}