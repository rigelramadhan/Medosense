package one.reevdev.modesense.core.data.feature.askmedicine.gemini.api

import android.graphics.Bitmap
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.Content
import com.google.ai.client.generativeai.type.content
import one.reevdev.medosense.core.common.utils.jsonToObject
import one.reevdev.modesense.core.data.BuildConfig
import one.reevdev.modesense.core.data.feature.askmedicine.gemini.model.AskMedicineResponse
import one.reevdev.modesense.core.data.feature.askmedicine.gemini.prompt.AskMedicineInstructionPrompt
import one.reevdev.modesense.core.data.utils.toContent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AskMedicineGeminiApi @Inject constructor() {

    private val generativeModel: GenerativeModel by lazy {
        GenerativeModel(
            modelName = "gemini-1.5-flash",
            apiKey = BuildConfig.apiKey
        )
    }

    private val chatHistory: MutableList<Content> = mutableListOf()

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

    suspend fun askMedicineByImage(image: Bitmap): AskMedicineResponse {
        val instruction = AskMedicineInstructionPrompt.askMedicineByImage()
        return sendGeminiMessage(instruction, AskMedicineResponse::class.java, image)
    }
}