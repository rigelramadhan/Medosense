package one.reevdev.medosense.feature.consult.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import one.reevdev.medosense.feature.common.theme.MedosenseTheme
import one.reevdev.medosense.feature.common.theme.appColors
import one.reevdev.medosense.feature.common.theme.appTypography

@Composable
fun ChipText(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier
            .background(color = appColors().primaryContainer, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 8.dp, vertical = 2.dp),
        text = text,
        style = appTypography().bodySmall,
        color = appColors().onPrimaryContainer
    )
}

@Preview(showBackground = true)
@Composable
private fun ChipTextPreview() {
    MedosenseTheme {
        ChipText(text = "Hello")
    }
}