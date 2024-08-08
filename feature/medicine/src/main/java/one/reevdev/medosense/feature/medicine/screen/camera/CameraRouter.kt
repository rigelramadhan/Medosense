package one.reevdev.medosense.feature.medicine.screen.camera

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import one.reevdev.medosense.core.common.utils.emptyString
import one.reevdev.medosense.feature.common.component.AppHeader
import one.reevdev.medosense.feature.common.screen.CameraScreen
import one.reevdev.medosense.feature.common.state.LoadingState
import one.reevdev.medosense.feature.common.utils.toBitmap
import one.reevdev.medosense.feature.medicine.screen.AskMedicineViewModel

@Composable
fun CameraRouter(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    viewModel: AskMedicineViewModel = hiltViewModel(),
    proceedToAnalysisResult: (Uri?) -> Unit,
) {
    var mediaUri by remember { mutableStateOf<Uri?>(null) }

    val pickMedia = rememberLauncherForActivityResult(contract = PickVisualMedia()) { uri ->
        if (uri != null) {
            viewModel.setLoading(LoadingState.DefaultLoading)
            mediaUri = uri
        }
    }

    LaunchedEffect(key1 = mediaUri) {
        if (mediaUri != null) {
            viewModel.setPhoto(mediaUri?.toBitmap(context))
            proceedToAnalysisResult(mediaUri)
            mediaUri = null
        }
    }

    Box(
        modifier = modifier,
    ) {
        CameraScreen(
            modifier = Modifier,
            onCapturePressed = {
                viewModel.setLoading(LoadingState.DefaultLoading)
            },
            onGalleryPressed = {
                pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
            },
            onSuccessCapture = {
                mediaUri = it
            }
        )
        AppHeader(title = emptyString(), isTransparent = true, hasBackButton = true)
    }
}