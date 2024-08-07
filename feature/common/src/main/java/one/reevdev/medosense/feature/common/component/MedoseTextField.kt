package one.reevdev.medosense.feature.common.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import one.reevdev.medosense.feature.common.theme.MedosenseTheme
import one.reevdev.medosense.feature.common.theme.appColors

@Composable
fun MedoseTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    colors: TextFieldColors = medoseTextFieldColors(),
    keyboardType: KeyboardType = KeyboardType.Text,
    isValueVisible: Boolean = true,
    prefix: String? = null,
    endButton: ImageVector? = null,
    onEndButtonClick: (() -> Unit)? = null,
    enabledIf: () -> Boolean = { true },
    onValueChange: (String) -> Unit,
) {
    TextField(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp)),
        value = value,
        enabled = enabledIf(),
        onValueChange = onValueChange,
        prefix = prefix?.run { { Text(prefix) } },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        visualTransformation = if (isValueVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = endButton?.run {
            {
                Icon(
                    modifier = Modifier.clickable { onEndButtonClick?.invoke() },
                    imageVector = this,
                    contentDescription = null
                )
            }
        },
        label = {
            Text(text = label)
        },
        colors = colors,
    )
}

@Composable
fun medoseTextFieldColors() = TextFieldDefaults.colors(
    unfocusedIndicatorColor = Color.Transparent,
    focusedContainerColor = appColors().surfaceContainerLow,
    unfocusedContainerColor = appColors().surfaceContainer
)

@Preview(showBackground = true)
@Composable
private fun DosenseTextFieldPreview() {
    MedosenseTheme {
        MedoseTextField(
            value = "Adama Traore",
            label = "Name",
            prefix = "Mr.",
            endButton = Icons.Default.AccountCircle
        ) {

        }
    }
}