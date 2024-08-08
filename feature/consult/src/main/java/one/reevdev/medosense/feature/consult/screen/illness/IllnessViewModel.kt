package one.reevdev.medosense.feature.consult.screen.illness

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import one.reevdev.medosense.core.domain.feature.consult.model.DiggingResult
import one.reevdev.medosense.core.domain.feature.consult.usecase.ConsultUseCase
import one.reevdev.medosense.feature.common.state.LoadingState
import one.reevdev.medosense.feature.common.state.UiState
import one.reevdev.medosense.feature.common.utils.handleResource
import javax.inject.Inject

@HiltViewModel
class IllnessViewModel @Inject constructor(
    private val useCase: ConsultUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(IllnessUiState())
    val uiState = _uiState.asStateFlow()

    fun submitSymptoms(symptoms: String) {
        viewModelScope.launch {
            useCase.initiateConsultation(symptoms)
                .catch {
                    _uiState.update {
                        it.copy(
                            loadingState = LoadingState.NotLoading,
                            error = it.error
                        )
                    }
                }
                .collect { result ->
                    _uiState.update { state ->
                        result.handleResource(
                            onSuccess = {
                                state.copy(
                                    loadingState = LoadingState.NotLoading,
                                    error = null,
                                    diggingResult = it
                                )
                            },
                            onFailure = { e, message ->
                                state.copy(
                                    loadingState = LoadingState.NotLoading,
                                    error = message ?: e.localizedMessage
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

    fun answerDiggingQuestion(answer: Boolean) {
        viewModelScope.launch {
            useCase.answerDiggingQuestion(answer)
                .catch {
                    _uiState.update {
                        it.copy(
                            loadingState = LoadingState.NotLoading,
                            error = it.error
                        )
                    }
                }
                .collect { result ->
                    _uiState.update { state ->
                        result.handleResource(
                            onSuccess = {
                                state.copy(
                                    loadingState = LoadingState.NotLoading,
                                    error = null,
                                    diggingResult = it
                                )
                            },
                            onFailure = { e, message ->
                                state.copy(
                                    loadingState = LoadingState.NotLoading,
                                    error = message ?: e.localizedMessage
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
}

data class IllnessUiState(
    override val loadingState: LoadingState = LoadingState.NotLoading,
    override val error: String? = null,
    val diggingResult: DiggingResult? = null
) : UiState