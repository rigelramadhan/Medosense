package one.reevdev.modesense.core.data.gemini

import android.graphics.Bitmap
import one.reevdev.modesense.core.data.gemini.api.IllnessGeminiApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GeminiDataSource @Inject constructor(
    private val geminiApi: IllnessGeminiApi
) {

    suspend fun initiateConsultation(symptoms: String) = geminiApi.initiateConsultation(symptoms)

    suspend fun answerQuestion(answer: Boolean) = geminiApi.answerQuestion(answer)

    suspend fun medicineImageConfirmation(bitmap: Bitmap) = geminiApi.medicineImageConfirmation(bitmap)
}