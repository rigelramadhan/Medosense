package one.reevdev.medosense.feature.consult.screen.medicine

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import one.reevdev.medosense.core.domain.feature.consult.model.IllnessAnalysis
import one.reevdev.medosense.core.domain.feature.consult.model.MedicineConfirmationResult
import one.reevdev.medosense.core.domain.feature.consult.usecase.ConsultUseCase
import one.reevdev.medosense.feature.common.state.LoadingState
import one.reevdev.medosense.feature.common.state.UiState
import one.reevdev.medosense.feature.common.utils.handleResource
import javax.inject.Inject

@HiltViewModel
class MedicineViewModel @Inject constructor(
    private val consultUseCase: ConsultUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(MedicineUiState())
    val uiState = _uiState.asStateFlow()

    fun confirmMedicine(bitmap: Bitmap) {
        viewModelScope.launch {
            consultUseCase.medicineImageConfirmation(bitmap)
                .collect { result ->
                    _uiState.update { state ->
                        result.handleResource(
                            onSuccess = {
                                state.copy(
                                    loadingState = LoadingState.NotLoading,
                                    error = null,
                                    result = it
                                )
                            },
                            onFailure = { throwable, message ->
                                state.copy(
                                    loadingState = LoadingState.NotLoading,
                                    error = message ?: throwable.localizedMessage.orEmpty()
                                )
                            },
                            onLoading = {
                                state.copy(
                                    loadingState = LoadingState.DefaultLoading,
                                    error = null
                                )
                            }
                        )
                    }
                }
        }
    }

    fun resetGemini() {
        consultUseCase.resetGemini()
    }

    fun setPhoto(photo: Bitmap?) {
        _uiState.update {
            it.copy(photo = photo)
        }
    }

    fun setLoading(isLoading: LoadingState) {
        _uiState.update {
            it.copy(loadingState = isLoading)
        }
    }

    fun setAnalysis(analysis: IllnessAnalysis) {
        _uiState.update {
            it.copy(analysis = analysis)
        }
    }
}

data class MedicineUiState(
    override val loadingState: LoadingState = LoadingState.NotLoading,
    override val error: String? = null,
    val photo: Bitmap? = null,
    val result: MedicineConfirmationResult? = null,
    val analysis: IllnessAnalysis? = null,
) : UiState