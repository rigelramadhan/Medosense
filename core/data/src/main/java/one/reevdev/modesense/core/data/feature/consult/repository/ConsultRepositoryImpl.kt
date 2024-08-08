package one.reevdev.modesense.core.data.feature.consult.repository

import android.graphics.Bitmap
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import one.reevdev.medosense.core.common.Result
import one.reevdev.modesense.core.data.gemini.GeminiDataSource
import one.reevdev.modesense.core.data.gemini.model.DiggingResponse
import one.reevdev.modesense.core.data.gemini.model.MedicineConfirmationResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConsultRepositoryImpl @Inject constructor(
    private val geminiDataSource: GeminiDataSource
) : ConsultRepository {
    override fun initiateConsultation(symptoms: String): Flow<Result<DiggingResponse>> = flow {
        emit(Result.Loading())
        try {
            val response = geminiDataSource.initiateConsultation(symptoms)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }

    override fun answerDiggingQuestion(answer: Boolean): Flow<Result<DiggingResponse>> = flow {
        emit(Result.Loading())
        try {
            val response = geminiDataSource.answerQuestion(answer)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }

    override fun medicineImageConfirmation(bitmap: Bitmap): Flow<Result<MedicineConfirmationResponse>> = flow {
        emit(Result.Loading())
        try {
            val response = geminiDataSource.medicineImageConfirmation(bitmap)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }

    override fun resetGemini(): Flow<Boolean> = flow {
        geminiDataSource.resetChatHistory()
        emit(true)
    }
}