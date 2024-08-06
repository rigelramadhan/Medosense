package one.reevdev.medosense.feature.consult.screen.illness.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import one.reevdev.medosense.feature.common.component.AppHeader
import one.reevdev.medosense.feature.common.theme.MedosenseTheme
import one.reevdev.medosense.feature.common.theme.appColors
import one.reevdev.medosense.feature.common.utils.emptyString

@Composable
fun IllnessInputRouter(
    modifier: Modifier = Modifier,
    onContinueClick: () -> Unit,
) {
    val (symptoms, onSymptomsValueChange) = remember { mutableStateOf(emptyString()) }

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
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                appColors().primary.copy(alpha = 0.5f),
                                appColors().onPrimaryContainer.copy(alpha = 0.5f)
                            )
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(color = appColors().surface)
            )
            IllnessInputScreen(
                modifier = Modifier
                    .align(Alignment.Center),
                symptoms = symptoms,
                onSymptomsValueChange = onSymptomsValueChange,
                onContinueClick = onContinueClick
            )
        }
    }
}

@Preview
@Composable
private fun IllnessInputRouterPreview() {
    MedosenseTheme {
        IllnessInputRouter(
            onContinueClick = {}
        )
    }
}