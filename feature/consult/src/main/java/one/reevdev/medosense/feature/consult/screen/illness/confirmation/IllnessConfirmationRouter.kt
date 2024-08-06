package one.reevdev.medosense.feature.consult.screen.illness.confirmation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import one.reevdev.medosense.core.common.utils.emptyString
import one.reevdev.medosense.feature.common.component.AppHeader
import one.reevdev.medosense.feature.common.theme.MedosenseTheme
import one.reevdev.medosense.feature.common.theme.appColors

@Composable
fun IllnessConfirmationRouter(
    modifier: Modifier = Modifier,
    question: String = emptyString(),
    onButtonClick: (isYes: Boolean) -> Unit,
) {
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
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            IllnessConfirmationScreen(
                question = question,
                onButtonClick = onButtonClick
            )
        }
    }
}

@Preview
@Composable
private fun IllnessConfirmationRouterPreview() {
    MedosenseTheme {
        IllnessConfirmationRouter(
            onButtonClick = {}
        )
    }
}