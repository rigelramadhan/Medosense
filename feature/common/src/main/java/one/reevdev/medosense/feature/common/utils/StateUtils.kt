package one.reevdev.medosense.feature.common.utils

import one.reevdev.medosense.core.common.Result
import one.reevdev.medosense.feature.common.state.LoadingState
import one.reevdev.medosense.feature.common.state.UiState

fun <T, State : UiState> Result<T>.handleResource(
    onSuccess: (T) -> State,
    onFailure: (Throwable, String?) -> State = { throwable, message ->
        generateUiState(
            error = message ?: throwable.localizedMessage.orEmpty(),
            loadingState = LoadingState.NotLoading
        )
    },
    onLoading: (T?) -> State = {
        generateUiState(
            error = null,
            loadingState = LoadingState.DefaultLoading
        )
    }
): State {
    return when (this) {
        is Result.Success -> {
            onSuccess(this.data)
        }

        is Result.Error -> {
            onFailure(this.error, this.errorMessage)
        }

        is Result.Loading -> {
            onLoading(this.data)
        }
    }
}

private fun <T : UiState> generateUiState(
    error: String? = null,
    loadingState: LoadingState = LoadingState.NotLoading
): T {
    val uiState = object : UiState {
        override val loadingState: LoadingState
            get() = loadingState

        override val error: String?
            get() = error
    }

    @Suppress("UNCHECKED_CAST")
    return (uiState as T)
}