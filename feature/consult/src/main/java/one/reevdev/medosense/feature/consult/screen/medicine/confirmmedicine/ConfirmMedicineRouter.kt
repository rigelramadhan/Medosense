package one.reevdev.medosense.feature.consult.screen.medicine.confirmmedicine

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Analytics
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.PhotoCamera
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import one.reevdev.medosense.feature.common.component.AppHeader
import one.reevdev.medosense.feature.common.state.LoadingState
import one.reevdev.medosense.feature.common.theme.appColors
import one.reevdev.medosense.feature.consult.R
import one.reevdev.medosense.feature.consult.screen.analysis.AnalysisCard
import one.reevdev.medosense.feature.consult.screen.medicine.MedicineViewModel

@Composable
fun ConfirmMedicineRouter(
    modifier: Modifier = Modifier,
    viewModel: MedicineViewModel = hiltViewModel(),
    onConfirmClick: () -> Unit,
    onContinueClick: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var showAnalysisResult by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = Unit) {
        uiState.photo?.let { viewModel.confirmMedicine(it) }
    }

    Scaffold(
        modifier = modifier,
        containerColor = appColors().primary,
        topBar = {
            AppHeader(
                isCentered = false,
                background = appColors().primary,
                logoTint = appColors().onPrimary,
                actions = {
                    IconButton(
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = appColors().onPrimary
                        ),
                        onClick = onConfirmClick
                    ) {
                        Icon(imageVector = Icons.Rounded.PhotoCamera, contentDescription = null)
                    }
                    IconButton(
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = appColors().onPrimary
                        ),
                        onClick = onContinueClick
                    ) {
                        Icon(imageVector = Icons.Rounded.Check, contentDescription = null)
                    }
                }
            )
        }
    ) {
        Box(modifier = Modifier) {
            ConfirmMedicineScreen(
                modifier = Modifier
                    .padding(it),
                confirmResult = uiState.result?.response.orEmpty(),
                photo = uiState.photo,
                isLoading = uiState.loadingState != LoadingState.NotLoading,
                onConfirmClick = onConfirmClick,
                onContinueClick = onContinueClick
            )
            ExtendedFloatingActionButton(
                modifier = Modifier
                    .padding(24.dp)
                    .align(Alignment.BottomEnd),
                icon = { Icon(imageVector = Icons.Rounded.Analytics, contentDescription = null) },
                text = { Text(text = stringResource(R.string.label_prescription)) },
                onClick = { showAnalysisResult = true }
            )
        }

        if (showAnalysisResult) {
            uiState.analysis?.run {
                Dialog(onDismissRequest = { showAnalysisResult = false }) {
                    AnalysisCard(
                        illness = illness,
                        confidenceLevel = confidenceLevel,
                        prescriptions = prescription,
                        onConfirmClick = null,
                        onContinueClick = null
                    )
                }
            }
        }
    }
}