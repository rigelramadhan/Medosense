package one.reevdev.medosense.feature.common.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import one.reevdev.medosense.feature.common.theme.appColors
import one.reevdev.medosense.feature.common.theme.appTypography

@Composable
fun LabelText(
    modifier: Modifier = Modifier,
    label: String,
    style: TextStyle = appTypography().bodyMedium,
    color: Color = appColors().onBackground.copy(alpha = 0.7f)
) {
    Text(
        modifier = modifier,
        text = label,
        style = style,
        color = color
    )
}