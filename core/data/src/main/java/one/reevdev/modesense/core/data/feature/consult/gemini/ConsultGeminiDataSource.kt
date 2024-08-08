package one.reevdev.modesense.core.data.feature.consult.gemini

import android.graphics.Bitmap
import one.reevdev.modesense.core.data.feature.consult.gemini.api.IllnessGeminiApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConsultGeminiDataSource @Inject constructor(
    private val geminiApi: IllnessGeminiApi
) {

    suspend fun initiateConsultation(symptoms: String) = geminiApi.initiateConsultation(symptoms)

    suspend fun answerQuestion(answer: Boolean) = geminiApi.answerQuestion(answer)

    suspend fun medicineImageConfirmation(bitmap: Bitmap) = geminiApi.medicineImageConfirmation(bitmap)

    fun resetChatHistory() = geminiApi.resetChatHistory()
}