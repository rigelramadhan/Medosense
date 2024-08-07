package one.reevdev.medosense.core.domain.feature.consult.usecase

import android.graphics.Bitmap
import kotlinx.coroutines.flow.Flow
import one.reevdev.medosense.core.common.Result
import one.reevdev.medosense.core.common.utils.mapFlowData
import one.reevdev.medosense.core.domain.feature.consult.model.DiggingResult
import one.reevdev.medosense.core.domain.feature.consult.model.MedicineConfirmationResult
import one.reevdev.medosense.core.domain.feature.consult.utils.toDomain
import one.reevdev.modesense.core.data.feature.consult.repository.ConsultRepository
import javax.inject.Inject

class ConsultInteractor @Inject constructor(
    private val consultRepository: ConsultRepository
) : ConsultUseCase {
    override fun initiateConsultation(symptoms: String): Flow<Result<DiggingResult>> {
        return consultRepository.initiateConsultation(symptoms).mapFlowData {
            it.toDomain()
        }
    }

    override fun answerDiggingQuestion(answer: Boolean): Flow<Result<DiggingResult>> {
        return consultRepository.answerDiggingQuestion(answer).mapFlowData {
            it.toDomain()
        }
    }

    override fun medicineImageConfirmation(bitmap: Bitmap): Flow<Result<MedicineConfirmationResult>> {
        return consultRepository.medicineImageConfirmation(bitmap).mapFlowData {
            it.toDomain()
        }
    }
}