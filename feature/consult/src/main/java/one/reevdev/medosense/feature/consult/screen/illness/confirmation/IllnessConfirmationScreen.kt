package one.reevdev.medosense.feature.consult.screen.illness.confirmation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import one.reevdev.medosense.core.common.utils.emptyString
import one.reevdev.medosense.feature.common.component.MedoseButton
import one.reevdev.medosense.feature.common.component.TonalMedoseButton
import one.reevdev.medosense.feature.common.theme.MedosenseTheme
import one.reevdev.medosense.feature.common.theme.appColors
import one.reevdev.medosense.feature.consult.R

@Composable
fun IllnessConfirmationScreen(
    modifier: Modifier = Modifier,
    question: String,
    onButtonClick: (isYes: Boolean) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (question.isEmpty())
            Image(
                modifier = Modifier
                    .offset(y = 24.dp),
                painter = painterResource(id = R.drawable.illustration_thinking),
                contentDescription = null
            )
        else
            Image(
                modifier = Modifier
                    .offset(y = 4.dp),
                painter = painterResource(id = R.drawable.illustration_yes_no),
                contentDescription = null
            )

        Card(
            modifier = Modifier,
            colors = CardDefaults.cardColors(
                containerColor = appColors().surface
            ),
            shape = RoundedCornerShape(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                if (question.isEmpty()) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(R.string.message_analyzing_your_symptoms),
                        textAlign = TextAlign.Center
                    )
                    LinearProgressIndicator(
                        modifier = Modifier
                            .padding(top = 16.dp, bottom = 8.dp)
                            .fillMaxWidth()
                    )
                } else {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = question,
                        textAlign = TextAlign.Center
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 32.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        TonalMedoseButton(
                            modifier = Modifier
                                .weight(1f),
                            text = stringResource(R.string.no),
                            onClick = { onButtonClick(false) }
                        )
                        MedoseButton(
                            modifier = Modifier
                                .weight(1f),
                            text = stringResource(R.string.yes),
                            onClick = { onButtonClick(true) }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF8C4A60)
@Composable
private fun IllnessConfirmationScreenPreview() {
    MedosenseTheme {
        IllnessConfirmationScreen(
            question = "Are you feeling some type of dizziness in your front area of your head?",
            onButtonClick = {}
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF8C4A60)
@Composable
private fun IllnessConfirmationScreenPreview_NotReady() {
    MedosenseTheme {
        IllnessConfirmationScreen(
            question = emptyString(),
            onButtonClick = {},
        )
    }
}