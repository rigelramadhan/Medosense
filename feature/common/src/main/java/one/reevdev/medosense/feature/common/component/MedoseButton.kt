package one.reevdev.medosense.feature.common.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun MedoseButton(
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
fun TonalMedoseButton(
    modifier: Modifier = Modifier,
    text: String,
    colors: ButtonColors = ButtonDefaults.filledTonalButtonColors(),
    enableIf: () -> Boolean = { true },
    onClick: () -> Unit,
) {
    FilledTonalButton(
        modifier = modifier,
        onClick = onClick,
        colors = colors,
        enabled = enableIf()
    ) {
        Text(text = text)
    }
}

@Composable
fun OutlinedMedoseButton(
    modifier: Modifier = Modifier,
    text: String,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    image: ImageVector? = null,
    enableIf: () -> Boolean = { true },
    onClick: () -> Unit,
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        colors = colors,
        enabled = enableIf()
    ) {
        image?.let {
            Icon(imageVector = image, contentDescription = null)
            Spacer(modifier = Modifier.width(4.dp))
        }
        Text(text = text)
    }
}