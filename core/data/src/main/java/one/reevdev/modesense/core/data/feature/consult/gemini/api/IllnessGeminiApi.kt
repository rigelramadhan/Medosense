package one.reevdev.modesense.core.data.feature.consult.gemini.api

import android.graphics.Bitmap
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.Content
import com.google.ai.client.generativeai.type.content
import one.reevdev.medosense.core.common.utils.jsonToObject
import one.reevdev.modesense.core.data.BuildConfig
import one.reevdev.modesense.core.data.feature.consult.gemini.model.DiggingResponse
import one.reevdev.modesense.core.data.feature.consult.gemini.model.MedicineConfirmationResponse
import one.reevdev.modesense.core.data.feature.consult.gemini.prompt.InstructionPrompt
import one.reevdev.modesense.core.data.utils.toContent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IllnessGeminiApi @Inject constructor() {
    private val generativeModel: GenerativeModel by lazy {
        GenerativeModel(
            modelName = "gemini-1.5-flash",
            apiKey = BuildConfig.apiKey
        )
    }

    private val chatHistory: MutableList<Content> = mutableListOf()

    init {
        chatHistory.add(
            content {
                text(InstructionPrompt.initializeIllnessAnalysisResponse())
            }
        )
    }

    private suspend fun <T> sendGeminiMessage(
        instruction: String,
        outputClass: Class<T>,
        photo: Bitmap? = null,
    ): T {
        val chat = generativeModel.startChat(chatHistory)

        val content = content {
            text(instruction)
            photo?.let { image(it) }
        }
        val response = chat.sendMessage(content).text.orEmpty()
        chatHistory.apply {
            add(content)
            add(response.toContent())
        }
        val data = response.jsonToObject(outputClass)
        return data
    }

    suspend fun initiateConsultation(
        symptoms: String
    ): DiggingResponse {
        val instruction = InstructionPrompt.initiateConstulation(symptoms)
        return sendGeminiMessage(instruction, DiggingResponse::class.java)
    }

    suspend fun answerQuestion(answer: Boolean): DiggingResponse {
        val instruction = InstructionPrompt.answerQuestion(answer)
        return sendGeminiMessage(instruction, DiggingResponse::class.java)
    }

    suspend fun medicineImageConfirmation(bitmap: Bitmap): MedicineConfirmationResponse {
        val instruction = InstructionPrompt.medicineImageConfirmation()
        return sendGeminiMessage(instruction, MedicineConfirmationResponse::class.java, bitmap)
    }

    fun resetChatHistory() {
        chatHistory.run {
            clear()
            add(
                content {
                    text(InstructionPrompt.initializeIllnessAnalysisResponse())
                }
            )
        }
    }
}