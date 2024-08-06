package one.reevdev.medosense.feature.common.state

interface UiState {
    val loadingState: LoadingState
    val error: String?
}