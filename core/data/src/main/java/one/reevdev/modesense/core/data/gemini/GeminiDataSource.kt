package one.reevdev.modesense.core.data.gemini

import one.reevdev.modesense.core.data.gemini.api.IllnessGeminiApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GeminiDataSource @Inject constructor(
    private val geminiApi: IllnessGeminiApi
) {

    suspend fun initiateConsultation(symptoms: String) = geminiApi.initiateConsultation(symptoms)
}