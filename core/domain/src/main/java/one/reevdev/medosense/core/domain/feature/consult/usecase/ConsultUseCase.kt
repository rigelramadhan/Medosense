package one.reevdev.medosense.core.domain.feature.consult.usecase

import android.graphics.Bitmap
import kotlinx.coroutines.flow.Flow
import one.reevdev.medosense.core.common.Result
import one.reevdev.medosense.core.domain.feature.consult.model.DiggingResult
import one.reevdev.medosense.core.domain.feature.consult.model.MedicineConfirmationResult

interface ConsultUseCase {

    fun initiateConsultation(symptoms: String): Flow<Result<DiggingResult>>

    fun answerDiggingQuestion(answer: Boolean): Flow<Result<DiggingResult>>

    fun medicineImageConfirmation(bitmap: Bitmap): Flow<Result<MedicineConfirmationResult>>
}