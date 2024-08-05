package one.reevdev.medosense.feature.common.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import one.reevdev.medosense.feature.common.theme.AppColors
import one.reevdev.medosense.feature.common.theme.AppTypography

@Composable
fun LabelText(
    modifier: Modifier = Modifier,
    label: String,
    style: TextStyle = AppTypography().bodyMedium,
    color: Color = AppColors().onBackground.copy(alpha = 0.7f)
) {
    Text(
        modifier = modifier,
        text = label,
        style = style,
        color = color
    )
}