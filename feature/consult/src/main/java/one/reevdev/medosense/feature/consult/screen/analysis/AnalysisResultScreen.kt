package one.reevdev.medosense.feature.consult.screen.analysis

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PhotoCamera
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import one.reevdev.medosense.core.domain.feature.consult.model.Prescription
import one.reevdev.medosense.feature.common.component.MedoseButton
import one.reevdev.medosense.feature.common.component.OutlinedMedoseButton
import one.reevdev.medosense.feature.common.theme.MedosenseTheme
import one.reevdev.medosense.feature.common.theme.appColors
import one.reevdev.medosense.feature.common.theme.appTypography
import one.reevdev.medosense.feature.consult.R
import one.reevdev.medosense.feature.consult.component.PrescriptionItem

@Composable
fun AnalysisResultScreen(
    modifier: Modifier = Modifier,
    illness: String,
    confidenceLevel: Double,
    prescriptions: List<Prescription>,
    onConfirmClick: () -> Unit,
    onContinueClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .offset(y = 8.dp),
            painter = painterResource(id = R.drawable.illustration_result),
            contentDescription = null
        )
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = appColors().surface),
            shape = RoundedCornerShape(24.dp)
        ) {
            LazyColumn(
                modifier = Modifier,
                contentPadding = PaddingValues(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 12.dp
                )
            ) {
                item {
                    Column {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = stringResource(R.string.message_based_on_my_analysis),
                            textAlign = TextAlign.Center,
                            style = appTypography().bodyMedium
                        )
                        Card(
                            modifier = Modifier
                                .padding(top = 14.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = appColors().primaryContainer,
                                contentColor = appColors().onPrimaryContainer
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    modifier = Modifier
                                        .weight(1f),
                                    text = illness,
                                    style = appTypography().titleMedium,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    modifier = Modifier,
                                    text = confidenceLevel.times(100).toInt().toString(),
                                    style = appTypography().bodyLarge,
                                    color = appColors().primary
                                )
                            }
                        }
                        Text(
                            modifier = Modifier
                                .padding(top = 28.dp),
                            text = stringResource(R.string.label_recommended_medicine),
                            style = appTypography().labelMedium
                        )
                    }
                }

                itemsIndexed(prescriptions) { index, item ->
                    PrescriptionItem(
                        modifier = Modifier.padding(top = 4.dp),
                        index = index.plus(1),
                        prescription = item
                    )
                }

                item {
                    Row(
                        modifier = Modifier
                            .padding(top = 32.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedMedoseButton(
                            modifier = Modifier
                                .weight(1f),
                            text = stringResource(R.string.label_confirm),
                            image = Icons.Rounded.PhotoCamera,
                            onClick = onConfirmClick
                        )
                        MedoseButton(
                            modifier = Modifier
                                .weight(1f),
                            text = stringResource(R.string.action_continue),
                            onClick = onContinueClick
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF8C4A60)
@Composable
private fun AnalysisResultScreenPreview() {
    MedosenseTheme {
        val prescription = Prescription(
            medicine = "Paracetamol",
            dosage = "500 mg",
            frequency = "1 tablet per day",
            duration = "3 days",
            notes = "Take with food"
        )
        AnalysisResultScreen(
            illness = "Daydream Fever",
            confidenceLevel = 0.85,
            prescriptions = listOf(
                prescription,
                prescription,
                prescription,
            ),
            onConfirmClick = {},
            onContinueClick = {}
        )
    }
}