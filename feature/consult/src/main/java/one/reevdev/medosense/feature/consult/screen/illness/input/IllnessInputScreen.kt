package one.reevdev.medosense.feature.consult.screen.illness.input

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import one.reevdev.medosense.feature.common.component.MedoseButton
import one.reevdev.medosense.feature.common.component.MedoseTextField
import one.reevdev.medosense.feature.common.theme.MedosenseTheme
import one.reevdev.medosense.feature.common.theme.appColors
import one.reevdev.medosense.feature.common.theme.appTypography
import one.reevdev.medosense.feature.consult.R

@Composable
fun IllnessInputScreen(
    modifier: Modifier = Modifier,
    symptoms: String,
    onSymptomsValueChange: (String) -> Unit,
    onContinueClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .offset(y = 1.dp),
            painter = painterResource(id = R.drawable.illustration_input_illness),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(appColors().surface)
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                textAlign = TextAlign.Center,
                text = stringResource(R.string.message_tell_me),
                style = appTypography().bodyLarge,
                color = appColors().onSurface
            )
            MedoseTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .padding(top = 16.dp),
                label = stringResource(R.string.label_symptoms),
                value = symptoms,
                onValueChange = onSymptomsValueChange
            )
            MedoseButton(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                text = stringResource(R.string.action_continue),
                colors = ButtonDefaults.buttonColors(
                    containerColor = appColors().primary
                ),
                onClick = onContinueClick
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF8C4A60)
@Composable
private fun IllnessInputScreenPreview() {
    MedosenseTheme {
        IllnessInputScreen(
            symptoms = "",
            onSymptomsValueChange = {},
            onContinueClick = {}
        )
    }
}