package one.reevdev.medosense.feature.common.utils

import one.reevdev.medosense.core.common.Result
import one.reevdev.medosense.feature.common.state.UiState

fun <T, State : UiState> Result<T>.handleResource(
    onSuccess: (T) -> State,
    onFailure: (Throwable, String?) -> State,
    onLoading: (T?) -> State
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