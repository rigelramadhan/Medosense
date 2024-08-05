package one.reevdev.medosense.feature.common.component

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DosenseButton(
    modifier: Modifier = Modifier,
    text: String,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    enableIf: () -> Boolean = { true },
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = colors,
        enabled = enableIf()
    ) {
        Text(text = text)
    }
}

@Composable
fun OutlinedDosenseButton(
    modifier: Modifier = Modifier,
    text: String,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    enableIf: () -> Boolean = { true },
    onClick: () -> Unit,
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        colors = colors,
        enabled = enableIf()
    ) {
        Text(text = text)
    }
}