package one.reevdev.medosense.feature.consult.screen.analysis

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import one.reevdev.medosense.core.domain.feature.consult.model.Prescription
import one.reevdev.medosense.feature.common.component.AppHeader
import one.reevdev.medosense.feature.common.theme.MedosenseTheme
import one.reevdev.medosense.feature.common.theme.appColors

@Composable
fun AnalysisResultRouter(
    modifier: Modifier = Modifier
) {
    val illness = "Something"
    val confidenceLevel = 0.87
    val prescription = listOf(
        Prescription(
            medicine = "Paracetamol",
            dosage = "500 mg",
            frequency = "1 tablet per day",
            duration = "3 days",
            notes = "Take with food"
        )
    )

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        containerColor = appColors().primary,
        topBar = {
            AppHeader(
                background = appColors().primary,
                logoTint = appColors().onPrimary
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            AnalysisResultScreen(
                modifier = Modifier
                    .padding(it),
                illness = illness,
                confidenceLevel = confidenceLevel,
                prescriptions = prescription
            )
        }
    }
}

@Preview
@Composable
private fun AnalysisResultRouterPreview() {
    MedosenseTheme {
        AnalysisResultRouter()
    }
}