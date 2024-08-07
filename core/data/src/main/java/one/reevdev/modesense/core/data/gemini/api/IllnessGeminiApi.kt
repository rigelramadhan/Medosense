package one.reevdev.modesense.core.data.gemini.api

import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.Content
import com.google.ai.client.generativeai.type.content
import one.reevdev.medosense.core.common.utils.jsonToObject
import one.reevdev.modesense.core.data.BuildConfig
import one.reevdev.modesense.core.data.gemini.model.DiggingResponse
import one.reevdev.modesense.core.data.gemini.prompt.InstructionPrompt
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

    suspend fun initiateConsultation(
        symptoms: String
    ): DiggingResponse {
        val chat = generativeModel.startChat(chatHistory)
        val instruction = InstructionPrompt.initiateConstulation(symptoms)

        val content = content {
            text(instruction)
        }
        val response = chat.sendMessage(content).text.orEmpty()
        chatHistory.apply {
            add(content)
            add(response.toContent())
        }
        val data = response.jsonToObject(DiggingResponse::class.java)
        return data
    }
}