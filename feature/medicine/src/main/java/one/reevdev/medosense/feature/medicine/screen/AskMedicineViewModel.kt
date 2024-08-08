package one.reevdev.medosense.feature.medicine.screen

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import one.reevdev.medosense.core.domain.feature.askmedicine.model.AskMedicineResult
import one.reevdev.medosense.core.domain.feature.askmedicine.usecase.AskMedicineUseCase
import one.reevdev.medosense.feature.common.state.LoadingState
import one.reevdev.medosense.feature.common.state.UiState
import one.reevdev.medosense.feature.common.utils.handleResource
import javax.inject.Inject

@HiltViewModel
class AskMedicineViewModel @Inject constructor(
    private val askMedicineUseCase: AskMedicineUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(AskMedicineUiState())
    val uiState = _uiState.asStateFlow()

    fun askMedicine(image: Bitmap) {
        viewModelScope.launch {
            askMedicineUseCase.askMedicine(image).collect { result ->
                _uiState.update { state ->
                    result.handleResource(
                        onSuccess = {
                            state.copy(
                                loadingState = LoadingState.NotLoading,
                                data = it
                            )
                        },
                        onLoading = {
                            state.copy(
                                loadingState = LoadingState.DefaultLoading
                            )
                        },
                        onFailure = { throwable, errorMessage ->
                            state.copy(
                                loadingState = LoadingState.NotLoading,
                                error = errorMessage ?: throwable.localizedMessage
                            )
                        }
                    )
                }
            }
        }
    }

    fun setPhoto(photo: Bitmap?) {
        _uiState.update {
            it.copy(photo = photo)
        }
    }

    fun setLoading(loadingState: LoadingState) {
        _uiState.update {
            it.copy(loadingState = loadingState)
        }
    }
}

data class AskMedicineUiState(
    override val loadingState: LoadingState = LoadingState.NotLoading,
    override val error: String? = null,
    val data: AskMedicineResult = AskMedicineResult(),
    val photo: Bitmap? = null,
) : UiState