package one.reevdev.medosense.feature.consult.screen.medicine.confirmmedicine

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PhotoCamera
import androidx.compose.material3.LinearProgressIndicator
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
import coil.compose.rememberAsyncImagePainter
import one.reevdev.medosense.feature.common.component.MedoseButton
import one.reevdev.medosense.feature.common.component.OutlinedMedoseButton
import one.reevdev.medosense.feature.common.theme.MedosenseTheme
import one.reevdev.medosense.feature.common.theme.appColors
import one.reevdev.medosense.feature.common.theme.appTypography
import one.reevdev.medosense.feature.consult.R

@Composable
fun ConfirmMedicineScreen(
    modifier: Modifier = Modifier,
    photo: Bitmap? = null,
    confirmResult: String,
    isLoading: Boolean = false,
    onConfirmClick: () -> Unit,
    onContinueClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(appColors().surface)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.2f)
                    .clip(RoundedCornerShape(16.dp))
                    .background(appColors().surfaceContainer),
                painter = rememberAsyncImagePainter(model = photo),
                contentDescription = stringResource(R.string.content_description_medicine_photo)
            )
            if (isLoading) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                )
                Text(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    text = stringResource(R.string.message_checking_photo),
                    textAlign = TextAlign.Center,
                    color = appColors().onSurface
                )
            } else {
                Box(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 16.dp,
                                topEnd = 16.dp,
                                bottomEnd = 16.dp
                            )
                        )
                        .background(color = appColors().tertiaryContainer)
                        .padding(16.dp)
                ) {
                    Text(
                        text = confirmResult,
                        style = appTypography().bodyMedium,
                        color = appColors().onTertiaryContainer
                    )
                }
                EqualWidthColumn(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .align(Alignment.End)
                ) {
                    OutlinedMedoseButton(
                        modifier = Modifier,
                        text = stringResource(id = R.string.label_confirm),
                        image = Icons.Rounded.PhotoCamera,
                        onClick = onConfirmClick
                    )
                    MedoseButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = stringResource(id = R.string.action_continue),
                        onClick = onContinueClick
                    )
                }
            }
        }
        Image(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 12.dp),
            painter = painterResource(id = R.drawable.illustration_confirm_result),
            contentDescription = null
        )
    }
}

@Composable
fun EqualWidthColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .width(IntrinsicSize.Max)
    ) {
        content()
    }
}


@Preview(showBackground = true, backgroundColor = 0xFF8C4A60)
@Composable
private fun ConfirmMedicineScreenPreview() {
    MedosenseTheme {
        ConfirmMedicineScreen(
            confirmResult = """
                Based on my analysis, you are having a condition that is not so severe. It can cause some things, such as:

                1. Thing 1
                2. Thing 2
                3. Thing 2
            """.trimIndent(),
            onConfirmClick = {},
            onContinueClick = {}
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF8C4A60)
@Composable
private fun ConfirmMedicineScreenPreview_Loading() {
    MedosenseTheme {
        ConfirmMedicineScreen(
            confirmResult = """
                Based on my analysis, you are having a condition that is not so severe. It can cause some things, such as:

                1. Thing 1
                2. Thing 2
                3. Thing 2
            """.trimIndent(),
            isLoading = true,
            onConfirmClick = {},
            onContinueClick = {}
        )
    }
}