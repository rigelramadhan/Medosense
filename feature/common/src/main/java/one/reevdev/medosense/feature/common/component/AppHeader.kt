package one.reevdev.medosense.feature.common.component

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import one.reevdev.medosense.feature.common.R
import one.reevdev.medosense.feature.common.theme.MedosenseTheme
import one.reevdev.medosense.feature.common.theme.appColors
import one.reevdev.medosense.feature.common.theme.appTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHeader(
    modifier: Modifier = Modifier,
    isCentered: Boolean = true,
    title: String? = null,
    logoTint: Color = appColors().primary,
    hasBackButton: Boolean = false,
    isTransparent: Boolean = false,
    background: Color = appColors().surface,
    actions: @Composable RowScope.() -> Unit = {},
) {
    val backPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val color = if (isTransparent) {
        TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White,
        )
    } else {
        TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = background,
            titleContentColor = appColors().primary,
            navigationIconContentColor = appColors().primary,
            actionIconContentColor = appColors().primary,
        )
    }
    val titleComponent: @Composable () -> Unit = {
        if (title != null) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                text = title,
                style = appTypography().headlineMedium,
                textAlign = TextAlign.Center
            )
        } else {
            Icon(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .height(28.dp),
                painter = painterResource(id = R.drawable.ic_medose_logo),
                contentDescription = stringResource(R.string.content_description_app_logo),
                tint = logoTint
            )
        }
    }
    val navIcon: @Composable () -> Unit = {
        if (hasBackButton) {
            IconButton(onClick = { backPressedDispatcher?.onBackPressed() }) {
                Icon(
                    modifier = Modifier
                        .padding(start = 8.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_back_24),
                    contentDescription = null,
                )
            }
        }
    }

    if (isCentered) {
        CenterAlignedTopAppBar(
            modifier = modifier,
            colors = color,
            title = titleComponent,
            navigationIcon = navIcon,
            actions = actions
        )
    } else {
        TopAppBar(
            modifier = modifier,
            colors = color,
            title = titleComponent,
            navigationIcon = navIcon,
            actions = actions
        )
    }
}

@Preview
@Composable
private fun AppHeaderPreview() {
    MedosenseTheme {
        AppHeader()
    }
}

@Preview
@Composable
private fun AppHeaderPreview_NotCentered() {
    MedosenseTheme {
        AppHeader(isCentered = false)
    }
}

@Preview
@Composable
private fun AppHeaderPreview_Title() {
    MedosenseTheme {
        AppHeader(
            title = "Vehicle",
            hasBackButton = true
        )
    }
}

@Preview
@Composable
private fun AppHeaderPreview_Title_NotCentered() {
    MedosenseTheme {
        AppHeader(
            title = "Vehicle",
            isCentered = false,
            hasBackButton = true
        )
    }
}