package one.reevdev.modesense.core.data.feature.consult.repository

import android.graphics.Bitmap
import kotlinx.coroutines.flow.Flow
import one.reevdev.medosense.core.common.Result
import one.reevdev.modesense.core.data.gemini.model.DiggingResponse
import one.reevdev.modesense.core.data.gemini.model.MedicineConfirmationResponse

interface ConsultRepository {

    fun initiateConsultation(symptoms: String): Flow<Result<DiggingResponse>>

    fun answerDiggingQuestion(answer: Boolean): Flow<Result<DiggingResponse>>

    fun medicineImageConfirmation(bitmap: Bitmap): Flow<Result<MedicineConfirmationResponse>>

}