package one.reevdev.medosense.feature.consult.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import one.reevdev.medosense.core.domain.feature.consult.model.Prescription
import one.reevdev.medosense.feature.common.theme.MedosenseTheme
import one.reevdev.medosense.feature.common.theme.appTypography

@Composable
fun PrescriptionItem(
    modifier: Modifier = Modifier,
    index: Int,
    prescription: Prescription
) {
    Row(modifier) {
        Text(
            text = "$index. ",
            style = appTypography().bodyMedium
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = prescription.medicine,
                style = appTypography().bodyMedium
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    listOf(
                        prescription.dosage,
                        prescription.frequency,
                        prescription.duration
                    )
                ) { item ->
                    ChipText(text = item)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PrescriptionItemPreview() {
    MedosenseTheme {
        val prescription = Prescription(
            medicine = "Paracetamol",
            dosage = "500 mg",
            frequency = "1 tablet per day",
            duration = "3 days",
            notes = "Take with food"
        )
        PrescriptionItem(index = 1, prescription = prescription)
    }
}